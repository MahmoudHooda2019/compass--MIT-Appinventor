# Add any ProGuard configurations specific to this
# extension here.

-keep public class com.aemo.compass.Compass {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'com/aemo/compass/repack'
-flattenpackagehierarchy
-dontpreverify
