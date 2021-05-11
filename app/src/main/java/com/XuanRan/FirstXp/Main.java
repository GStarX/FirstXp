package com.XuanRan.FirstXp;

import de.robv.android.xposed.*;
import de.robv.android.xposed.callbacks.*;
import android.widget.TextView;
import de.robv.android.xposed.XC_MethodHook.MethodHookParam;

/**
 *   Created By XuanRan on 2021/05/11
 *   演示Xposed开发
 */

public class Main implements IXposedHookLoadPackage
{
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable
    {
		//指定要Hook的应用
		
        if(loadPackageParam.packageName.equals("com.XuanRan.FirstXp")){
			
			XposedBridge.hookAllMethods(TextView.class,"setText",new ChangeText());
			
        }
    }
}


class ChangeText extends XC_MethodHook
{

	@Override
	protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable
	{
		super.beforeHookedMethod(param);
		param.args[0] = "卧槽";
	}
	
}
