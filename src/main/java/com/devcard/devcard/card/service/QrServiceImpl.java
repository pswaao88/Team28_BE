package com.devcard.devcard.card.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class QrServiceImpl implements QrService{

    private static final int QR_SIZE_WIDTH = 200;
    private static final int QR_SIZE_HEIGHT = 200;
    private static final String DOMAIN_URI = "http://localhost:8080/";
    private final String QR_CODE_DIRECTORY = "src/main/resources/static/qrcodes/";

    /**
     * @param cardId QR로 만들 명함 ID
     * @return QR 코드 IMAGE 파일 이름만 반환
     */
    @Override
    public String createQr(Long cardId) throws WriterException, IOException {

        // QR URL - QR 코드 정보 URL
        String url = DOMAIN_URI + "cards/" + cardId;

        // QR Code - BitMatrix: qr code 정보 생성
        BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, QR_SIZE_WIDTH, QR_SIZE_HEIGHT);

        // Setting QR Image File Name, Path
        String qrFileName = "card_id_" + cardId + ".png";
        Path qrPath = Paths.get(QR_CODE_DIRECTORY + qrFileName);

        // Save QR
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();)
        {
            MatrixToImageWriter.writeToStream(bitMatrix, "png", out);
            Files.createDirectories(qrPath.getParent()); // 디렉토리 없는 경우 생성
            Files.write(qrPath, out.toByteArray());
        }

        return DOMAIN_URI + "qrcodes/" + qrFileName;
    }
}
