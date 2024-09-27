package com.devcard.devcard.card.service;

import com.google.zxing.WriterException;

import java.io.IOException;

public interface QrService {

    Object createQr(Long cardId) throws WriterException, IOException;
}
