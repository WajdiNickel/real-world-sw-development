package com.iteratrlearning.shu_book.chapter04;

import java.io.File;
import java.io.IOException;

interface Importer {
    Document importFile(File file) throws IOException;
}
