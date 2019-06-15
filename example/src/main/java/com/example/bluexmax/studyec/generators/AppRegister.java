package com.example.bluexmax.studyec.generators;


import com.example.latte_annotations.AppRegisterGenerator;
import com.example.latte_core.wechat.templetes.AppRegisterTemplate;

@SuppressWarnings("unused")
@AppRegisterGenerator(
        packageName = "com.example.bluexmax.studyec",
        registerTemplate = AppRegisterTemplate.class
)
public interface AppRegister {
}
