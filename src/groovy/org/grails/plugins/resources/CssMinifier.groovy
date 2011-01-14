package org.grails.plugins.resources

import com.yahoo.platform.yui.compressor.CssCompressor;


class CssMinifier implements Minifier {

    void minify (File sourceFile, File targetFile) {

        def out = new OutputStreamWriter(new FileOutputStream(targetFile), "UTF-8")
        try {
            def lineBreakPos = -1
            new CssCompressor(new BufferedReader(new FileReader(sourceFile))).compress(out, lineBreakPos)
        } finally {
            out.close()
        }
    }
}

