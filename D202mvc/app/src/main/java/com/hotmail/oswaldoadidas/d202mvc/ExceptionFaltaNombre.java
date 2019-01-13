package com.hotmail.oswaldoadidas.d202mvc;

/**
 * Created by oswaldosaldivar on 13/04/16.
 */

import android.support.annotation.NonNull;
public class ExceptionFaltaNombre extends Exception {

    public ExceptionFaltaNombre(@NonNull String detailMessage) {

        super(detailMessage);

    }

}
