# CitypickerLibrary
城市列表library
## 展示

![image](https://github.com/ysrfeng/CitypickerLibrary/blob/master/doc/Screenrecorder01.gif)

## 导入方式
Step 1.工程app的build下加入
Add it in your root build.gradle at the end of repositories:
```Java
 allprojects {
 		repositories {
 			...
 			maven { url 'https://jitpack.io' }
 		}
 	}
```
Step 2. Add the dependency
```Java
	dependencies {
	        compile 'com.github.ysrfeng:CitypickerLibrary:v3.0'
	}
```


Step 3.在你项目的`manifest.xml`中添加开发平台申请的key

```xml
<meta-data android:name="com.amap.api.v2.apikey"
           android:value="your key"/>
```
Step 4.还需要添加`CityPickerActivity`

```xml
<activity
            android:name="com.ysr.citypicker.CityPickerActivity"
            android:theme="@style/CityPicker.NoActionBar"
            android:screenOrientation="portrait"
            android:windowSoftInputMode="stateHidden|adjustPan"/>
```
### 使用
```Java
                ARouter.getInstance().build("/lib/CityPickerActivity").navigation(MainActivity.this, REQUEST_CODE_PICK_CITY);
//                startActivityForResult(new Intent(MainActivity.this, CityPickerActivity.class),
//                        REQUEST_CODE_PICK_CITY);
```
```Java
  @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK) {
            if (data != null) {
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                tv_click.setText("当前选择：" + city);
            }
        }
    }
```

### 注意混淆
```java
-keep class com.amap.api.location.**{*;}
-keep class com.amap.api.fence.**{*;}
-keep class com.autonavi.aps.amapapi.model.**{*;}
```