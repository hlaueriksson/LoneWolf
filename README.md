LoneWolf
========

LoneWolf is a series of books/games on the Android platform.

This repo only contains the code to make the games run on Android.
The content of the books are published and hosted by [Project Aon](http://www.projectaon.org/)

Requirements
------------

Android Studio

- http://developer.android.com/sdk/index.html

Android 5.0.1 (API 21) SDK Platform

- http://developer.android.com/sdk/installing/adding-packages.html

Content
-------

The [LoneWolfMigration](https://github.com/hlaueriksson/LoneWolfMigration) project generates content for the app.

Copy the generated output from LoneWolfMigration to:

- \dev\android\LoneWolf\app\src\main\assets\

Installation
------------

To install/reinstall/uninstall the app on a device run: 

- \dev\android\LoneWolf\install.bat
- \dev\android\LoneWolf\reinstall.bat
- \dev\android\LoneWolf\uninstall.bat

Unit Tests
----------

Unit tests are located under;

- \dev\android\LoneWolf\base\src\androidTest\

### Work around for "!!! JUnit version 3.8 or later expected:"

![Fail](https://raw.githubusercontent.com/hlaueriksson/LoneWolf/master/fail.png)

Running the unit tests requires some configuration. The fix is described on Kostya Y's Blog; http://kostyay.name/android-studio-robolectric-gradle-getting-work/

#### TL;DR

Copy the `-classpath` from the error message and modify:

1. Cut the path to `junit-4.11.jar` and paste it as the first argument
1. Add the absolute path to the built test classes `\dev\android\LoneWolf\base\build\intermediates\classes\test\debug\` as the last argument

The end result should look somewhat like this:

```
-classpath "C:\Users\henrik.eriksson\.gradle\caches\modules-2\files-2.1\junit\junit\4.11\4e031bb61df09069aeb2bffb4019e7a5034a4ee0\junit-4.11.jar;C:\Program Files\Android\Android Studio\lib\idea_rt.jar;C:\Program Files\Android\Android Studio\plugins\junit\lib\junit-rt.jar;C:\Users\henrik.eriksson\AppData\Local\Android\sdk\platforms\android-21\android.jar;C:\Users\henrik.eriksson\AppData\Local\Android\sdk\platforms\android-21\data\res;C:\work\git\github\hlaueriksson\LoneWolf\dev\android\LoneWolf\base\build\intermediates\classes\debug;C:\Users\henrik.eriksson\.gradle\caches\modules-2\files-2.1\org.roboguice\roboguice\3.0.1\24e814f35d5cc28eaa7e9f07a50ea69deeb2b544\roboguice-3.0.1.jar;C:\work\git\github\hlaueriksson\LoneWolf\dev\android\LoneWolf\app\build\intermediates\exploded-aar\com.android.support\support-v4\21.0.3\classes.jar;C:\work\git\github\hlaueriksson\LoneWolf\dev\android\LoneWolf\app\build\intermediates\exploded-aar\com.android.support\support-v4\21.0.3\res;C:\work\git\github\hlaueriksson\LoneWolf\dev\android\LoneWolf\app\build\intermediates\exploded-aar\com.android.support\support-v4\21.0.3\libs\internal_impl-21.0.3.jar;C:\Users\henrik.eriksson\.gradle\caches\modules-2\files-2.1\org.hamcrest\hamcrest-core\1.3\42a25dc3219429f0e5d060061f71acb49bf010a0\hamcrest-core-1.3.jar;C:\Users\henrik.eriksson\.gradle\caches\modules-2\files-2.1\commons-collections\commons-collections\3.2.1\761ea405b9b37ced573d2df0d1e3a4e0f9edc668\commons-collections-3.2.1.jar;C:\Users\henrik.eriksson\.gradle\caches\modules-2\files-2.1\com.google.code.gson\gson\2.3.1\ecb6e1f8e4b0e84c4b886c2f14a1500caf309757\gson-2.3.1.jar;C:\Users\henrik.eriksson\.gradle\caches\modules-2\files-2.1\org.objenesis\objenesis\2.1\87c0ea803b69252868d09308b4618f766f135a96\objenesis-2.1.jar;C:\work\git\github\hlaueriksson\LoneWolf\dev\android\LoneWolf\app\build\intermediates\exploded-aar\com.android.support\appcompat-v7\21.0.3\res;C:\work\git\github\hlaueriksson\LoneWolf\dev\android\LoneWolf\app\build\intermediates\exploded-aar\com.android.support\appcompat-v7\21.0.3\classes.jar;C:\Users\henrik.eriksson\.gradle\caches\modules-2\files-2.1\org.roboguice\roboblender\3.0.1\d629079b9bfa8d889ec833d1eb747e89cf789bfa\roboblender-3.0.1.jar;C:\Users\henrik.eriksson\AppData\Local\Android\sdk\extras\android\m2repository\com\android\support\support-annotations\21.0.3\support-annotations-21.0.3.jar;C:\Users\henrik.eriksson\.gradle\caches\modules-2\files-2.1\commons-lang\commons-lang\2.4\16313e02a793435009f1e458fa4af5d879f6fb11\commons-lang-2.4.jar;C:\Users\henrik.eriksson\.gradle\caches\modules-2\files-2.1\org.mockito\mockito-core\1.10.19\e8546f5bef4e061d8dd73895b4e8f40e3fe6effe\mockito-core-1.10.19.jar;C:\Users\henrik.eriksson\.gradle\caches\modules-2\files-2.1\org.apache.velocity\velocity\1.7\2ceb567b8f3f21118ecdec129fe1271dbc09aa7a\velocity-1.7.jar;C:\work\git\github\hlaueriksson\LoneWolf\dev\android\LoneWolf\base\build\intermediates\classes\test\debug\"
```

Paste the `-classpath` to the VM options:

![Fix](https://raw.githubusercontent.com/hlaueriksson/LoneWolf/master/fix.png)
