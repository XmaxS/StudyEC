package com.example.bluexmax.studyec.generators;


import com.example.latte_annotations.PayEntryGenerator;
import com.example.latte_core.wechat.templetes.WXPayEntryTemplate;

@SuppressWarnings("unused")
@PayEntryGenerator(
        packageName = "com.example.bluexmax.studyec",
        payEntryTemplate = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
