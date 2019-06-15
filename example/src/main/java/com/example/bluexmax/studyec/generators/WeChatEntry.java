package com.example.bluexmax.studyec.generators;


import com.example.latte_annotations.EntryGenerator;
import com.example.latte_core.wechat.templetes.WXEntryTemplate;

@SuppressWarnings("unused")
@EntryGenerator(
        packageName = "com.example.bluexmax.studyec",
        entryTemplate = WXEntryTemplate.class
)
public interface WeChatEntry {
}
