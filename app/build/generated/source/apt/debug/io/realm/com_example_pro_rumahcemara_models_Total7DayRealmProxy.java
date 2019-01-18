package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_example_pro_rumahcemara_models_Total7DayRealmProxy extends com.example.pro.rumahcemara.models.Total7Day
    implements RealmObjectProxy, com_example_pro_rumahcemara_models_Total7DayRealmProxyInterface {

    static final class Total7DayColumnInfo extends ColumnInfo {
        long dateIndex;
        long totalIndex;

        Total7DayColumnInfo(OsSchemaInfo schemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Total7Day");
            this.dateIndex = addColumnDetails("date", "date", objectSchemaInfo);
            this.totalIndex = addColumnDetails("total", "total", objectSchemaInfo);
        }

        Total7DayColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new Total7DayColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final Total7DayColumnInfo src = (Total7DayColumnInfo) rawSrc;
            final Total7DayColumnInfo dst = (Total7DayColumnInfo) rawDst;
            dst.dateIndex = src.dateIndex;
            dst.totalIndex = src.totalIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private Total7DayColumnInfo columnInfo;
    private ProxyState<com.example.pro.rumahcemara.models.Total7Day> proxyState;

    com_example_pro_rumahcemara_models_Total7DayRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (Total7DayColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.pro.rumahcemara.models.Total7Day>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$date() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.dateIndex);
    }

    @Override
    public void realmSet$date(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.dateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.dateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.dateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.dateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$total() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.totalIndex);
    }

    @Override
    public void realmSet$total(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.totalIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.totalIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.totalIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.totalIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Total7Day", 2, 0);
        builder.addPersistedProperty("date", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("total", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static Total7DayColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new Total7DayColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Total7Day";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Total7Day";
    }

    @SuppressWarnings("cast")
    public static com.example.pro.rumahcemara.models.Total7Day createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.pro.rumahcemara.models.Total7Day obj = realm.createObjectInternal(com.example.pro.rumahcemara.models.Total7Day.class, true, excludeFields);

        final com_example_pro_rumahcemara_models_Total7DayRealmProxyInterface objProxy = (com_example_pro_rumahcemara_models_Total7DayRealmProxyInterface) obj;
        if (json.has("date")) {
            if (json.isNull("date")) {
                objProxy.realmSet$date(null);
            } else {
                objProxy.realmSet$date((String) json.getString("date"));
            }
        }
        if (json.has("total")) {
            if (json.isNull("total")) {
                objProxy.realmSet$total(null);
            } else {
                objProxy.realmSet$total((String) json.getString("total"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.pro.rumahcemara.models.Total7Day createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.example.pro.rumahcemara.models.Total7Day obj = new com.example.pro.rumahcemara.models.Total7Day();
        final com_example_pro_rumahcemara_models_Total7DayRealmProxyInterface objProxy = (com_example_pro_rumahcemara_models_Total7DayRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("date")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$date((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$date(null);
                }
            } else if (name.equals("total")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$total((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$total(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.example.pro.rumahcemara.models.Total7Day copyOrUpdate(Realm realm, com.example.pro.rumahcemara.models.Total7Day object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.pro.rumahcemara.models.Total7Day) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.example.pro.rumahcemara.models.Total7Day copy(Realm realm, com.example.pro.rumahcemara.models.Total7Day newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.pro.rumahcemara.models.Total7Day) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.example.pro.rumahcemara.models.Total7Day realmObject = realm.createObjectInternal(com.example.pro.rumahcemara.models.Total7Day.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_example_pro_rumahcemara_models_Total7DayRealmProxyInterface realmObjectSource = (com_example_pro_rumahcemara_models_Total7DayRealmProxyInterface) newObject;
        com_example_pro_rumahcemara_models_Total7DayRealmProxyInterface realmObjectCopy = (com_example_pro_rumahcemara_models_Total7DayRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$date(realmObjectSource.realmGet$date());
        realmObjectCopy.realmSet$total(realmObjectSource.realmGet$total());
        return realmObject;
    }

    public static long insert(Realm realm, com.example.pro.rumahcemara.models.Total7Day object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.pro.rumahcemara.models.Total7Day.class);
        long tableNativePtr = table.getNativePtr();
        Total7DayColumnInfo columnInfo = (Total7DayColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Total7Day.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$date = ((com_example_pro_rumahcemara_models_Total7DayRealmProxyInterface) object).realmGet$date();
        if (realmGet$date != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
        }
        String realmGet$total = ((com_example_pro_rumahcemara_models_Total7DayRealmProxyInterface) object).realmGet$total();
        if (realmGet$total != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.totalIndex, rowIndex, realmGet$total, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.pro.rumahcemara.models.Total7Day.class);
        long tableNativePtr = table.getNativePtr();
        Total7DayColumnInfo columnInfo = (Total7DayColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Total7Day.class);
        com.example.pro.rumahcemara.models.Total7Day object = null;
        while (objects.hasNext()) {
            object = (com.example.pro.rumahcemara.models.Total7Day) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$date = ((com_example_pro_rumahcemara_models_Total7DayRealmProxyInterface) object).realmGet$date();
            if (realmGet$date != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
            }
            String realmGet$total = ((com_example_pro_rumahcemara_models_Total7DayRealmProxyInterface) object).realmGet$total();
            if (realmGet$total != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.totalIndex, rowIndex, realmGet$total, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.pro.rumahcemara.models.Total7Day object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.pro.rumahcemara.models.Total7Day.class);
        long tableNativePtr = table.getNativePtr();
        Total7DayColumnInfo columnInfo = (Total7DayColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Total7Day.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$date = ((com_example_pro_rumahcemara_models_Total7DayRealmProxyInterface) object).realmGet$date();
        if (realmGet$date != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.dateIndex, rowIndex, false);
        }
        String realmGet$total = ((com_example_pro_rumahcemara_models_Total7DayRealmProxyInterface) object).realmGet$total();
        if (realmGet$total != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.totalIndex, rowIndex, realmGet$total, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.totalIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.pro.rumahcemara.models.Total7Day.class);
        long tableNativePtr = table.getNativePtr();
        Total7DayColumnInfo columnInfo = (Total7DayColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Total7Day.class);
        com.example.pro.rumahcemara.models.Total7Day object = null;
        while (objects.hasNext()) {
            object = (com.example.pro.rumahcemara.models.Total7Day) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$date = ((com_example_pro_rumahcemara_models_Total7DayRealmProxyInterface) object).realmGet$date();
            if (realmGet$date != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.dateIndex, rowIndex, false);
            }
            String realmGet$total = ((com_example_pro_rumahcemara_models_Total7DayRealmProxyInterface) object).realmGet$total();
            if (realmGet$total != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.totalIndex, rowIndex, realmGet$total, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.totalIndex, rowIndex, false);
            }
        }
    }

    public static com.example.pro.rumahcemara.models.Total7Day createDetachedCopy(com.example.pro.rumahcemara.models.Total7Day realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.pro.rumahcemara.models.Total7Day unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.pro.rumahcemara.models.Total7Day();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.pro.rumahcemara.models.Total7Day) cachedObject.object;
            }
            unmanagedObject = (com.example.pro.rumahcemara.models.Total7Day) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_pro_rumahcemara_models_Total7DayRealmProxyInterface unmanagedCopy = (com_example_pro_rumahcemara_models_Total7DayRealmProxyInterface) unmanagedObject;
        com_example_pro_rumahcemara_models_Total7DayRealmProxyInterface realmSource = (com_example_pro_rumahcemara_models_Total7DayRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$date(realmSource.realmGet$date());
        unmanagedCopy.realmSet$total(realmSource.realmGet$total());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Total7Day = proxy[");
        stringBuilder.append("{date:");
        stringBuilder.append(realmGet$date() != null ? realmGet$date() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{total:");
        stringBuilder.append(realmGet$total() != null ? realmGet$total() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_example_pro_rumahcemara_models_Total7DayRealmProxy aTotal7Day = (com_example_pro_rumahcemara_models_Total7DayRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aTotal7Day.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aTotal7Day.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aTotal7Day.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
