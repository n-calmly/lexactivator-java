package com.cryptlex.lexactivator;

import com.sun.jna.Library;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.WString;
import java.nio.CharBuffer;
import java.nio.ByteBuffer;
import com.sun.jna.ptr.IntByReference;
import java.io.File;

public class LexActivatorNative implements Library
{

    public static NativeLibrary GetNativeLibrary()
    {
        String libraryPath, libraryName, arch;
        libraryPath = System.getProperty("user.dir") + File.separator + "lexactivator";
        libraryName = null;
        arch = Platform.is64Bit() ? "-64" : "";
        switch (Platform.getOSType())
        {
            case Platform.WINDOWS:
                libraryPath = libraryPath + File.separator + "win32-x86" + arch;
                libraryName = "LexActivator.dll";
                break;
            case Platform.MAC:
                libraryPath = libraryPath + File.separator + "mac";
                libraryName = "libLexActivator.dylib";
                break;
            case Platform.LINUX:
                libraryPath = libraryPath + File.separator + "linux-x86" + arch;
                libraryName = "libLexActivator.so";
                break;
        }
        return NativeLibrary.getInstance(libraryPath + File.separator + libraryName);

    }

    static
    {
        Native.register(GetNativeLibrary());
    }

    public static native int SetProductFile(String filePath);

    public static native int SetProductFile(WString filePath);

    public static native int SetVersionGUID(String versionGUID, int flags);

    public static native int SetVersionGUID(WString versionGUID, int flags);

    public static native int SetProductKey(String productKey);

    public static native int SetProductKey(WString productKey);

    public static native int SetExtraActivationData(String extraData);

    public static native int SetExtraActivationData(WString extraData);

    public static native int ActivateProduct();

    public static native int DeactivateProduct();

    public static native int ActivateProductOffline(String filePath);

    public static native int ActivateProductOffline(WString filePath);

    public static native int GenerateOfflineActivationRequest(String filePath);

    public static native int GenerateOfflineActivationRequest(WString filePath);

    public static native int GenerateOfflineDeactivationRequest(String filePath);

    public static native int GenerateOfflineDeactivationRequest(WString filePath);

    public static native int IsProductGenuine();

    public static native int IsProductActivated();
    
    public static native int GetExtraActivationData(ByteBuffer extraData, int length);

    public static native int GetExtraActivationData(CharBuffer extraData, int length);

    public static native int GetCustomLicenseField(String fieldId, ByteBuffer fieldValue, int length);

    public static native int GetCustomLicenseField(WString fieldId, CharBuffer fieldValue, int length);

    public static native int GetProductKey(ByteBuffer productKey, int length);

    public static native int GetProductKey(CharBuffer productKey, int length);
    
    public static native int GetDaysLeftToExpiration(IntByReference daysLeft);

    public static native int GetProductKeyExpiryDate(IntByReference expiryDate);

    public static native int SetTrialKey(String trialKey);

    public static native int SetTrialKey(WString trialKey);

    public static native int ActivateTrial();

    public static native int IsTrialGenuine();

    public static native int ExtendTrial(String trialExtensionKey);

    public static native int ExtendTrial(WString trialExtensionKey);

    public static native int InitializeTrial(int trialLength);

    public static native int GetTrialDaysLeft(IntByReference daysLeft, int trialType);

    public static native int SetDayIntervalForServerCheck(int dayInterval);

    public static native int SetGracePeriodForNetworkError(int gracePeriod);

    public static native int SetNetworkProxy(String proxy);

    public static native int SetNetworkProxy(WString proxy);
    
    public static native int SetCryptlexHost(String host);

    public static native int SetUserLock(Boolean userLock);

    public static native int SetCryptlexHost(WString host);
}
