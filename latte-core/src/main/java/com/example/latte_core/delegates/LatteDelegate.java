package com.example.latte_core.delegates;

import com.example.latte_core.activities.PermissionCheckerDelegate;


public abstract class LatteDelegate extends PermissionCheckerDelegate {

    @SuppressWarnings("unchecked")
    public <T extends LatteDelegate> T getParentDelegate() {
        return (T) getParentFragment();
    }
}
