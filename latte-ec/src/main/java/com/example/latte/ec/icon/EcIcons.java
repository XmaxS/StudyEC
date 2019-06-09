package com.example.latte.ec.icon;

import com.joanzapata.iconify.Icon;

public enum EcIcons implements Icon {
    //图标序号,取后四位
    icon_scan('\ue63b'),
    icon_ali_pay('\ue68b');

    private char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
