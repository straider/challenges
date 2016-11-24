package com.github.straider.osgi.consumer;

import com.github.straider.osgi.common.Translator;

public class TranslatorClient {

    private static final String TEXT = "Be very very quiet. I’m hunting rabbits!";

    private Translator translator;

    public void go() {
        System.out.println( String.format( "Translated: %s", translator.translate( TEXT ) ) );
    }

    public void setTranslator( final Translator translator ) {
        this.translator = translator;
    }

}
