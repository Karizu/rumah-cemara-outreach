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
public class com_example_pro_rumahcemara_models_DashboardRealmProxy extends com.example.pro.rumahcemara.models.Dashboard
    implements RealmObjectProxy, com_example_pro_rumahcemara_models_DashboardRealmProxyInterface {

    static final class DashboardColumnInfo extends ColumnInfo {
        long totalRangeIndex;
        long totalMonthIndex;

        DashboardColumnInfo(OsSchemaInfo schemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Dashboard");
            this.totalRangeIndex = addColumnDetails("totalRange", "totalRange", objectSchemaInfo);
            this.totalMonthIndex = addColumnDetails("totalMonth", "totalMonth", objectSchemaInfo);
        }

        DashboardColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new DashboardColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final DashboardColumnInfo src = (DashboardColumnInfo) rawSrc;
            final DashboardColumnInfo dst = (DashboardColumnInfo) rawDst;
            dst.totalRangeIndex = src.totalRangeIndex;
            dst.totalMonthIndex = src.totalMonthIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private DashboardColumnInfo columnInfo;
    private ProxyState<com.example.pro.rumahcemara.models.Dashboard> proxyState;

    com_example_pro_rumahcemara_models_DashboardRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (DashboardColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.pro.rumahcemara.models.Dashboard>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$totalRange() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.totalRangeIndex);
    }

    @Override
    public void realmSet$totalRange(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.totalRangeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.totalRangeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.totalRangeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.totalRangeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$totalMonth() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.totalMonthIndex);
    }

    @Override
    public void realmSet$totalMonth(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.totalMonthIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.totalMonthIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.totalMonthIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.totalMonthIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Dashboard", 2, 0);
        builder.addPersistedProperty("totalRange", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("totalMonth", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static DashboardColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new DashboardColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Dashboard";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Dashboard";
    }

    @SuppressWarnings("cast")
    public static com.example.pro.rumahcemara.models.Dashboard createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.pro.rumahcemara.models.Dashboard obj = realm.createObjectInternal(com.example.pro.rumahcemara.models.Dashboard.class, true, excludeFields);

        final com_example_pro_rumahcemara_models_DashboardRealmProxyInterface objProxy = (com_example_pro_rumahcemara_models_DashboardRealmProxyInterface) obj;
        if (json.has("totalRange")) {
            if (json.isNull("totalRange")) {
                objProxy.realmSet$totalRange(null);
            } else {
                objProxy.realmSet$totalRange((String) json.getString("totalRange"));
            }
        }
        if (json.has("totalMonth")) {
            if (json.isNull("totalMonth")) {
                objProxy.realmSet$totalMonth(null);
            } else {
                objProxy.realmSet$totalMonth((String) json.getString("totalMonth"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.pro.rumahcemara.models.Dashboard createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.example.pro.rumahcemara.models.Dashboard obj = new com.example.pro.rumahcemara.models.Dashboard();
        final com_example_pro_rumahcemara_models_DashboardRealmProxyInterface objProxy = (com_example_pro_rumahcemara_models_DashboardRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("totalRange")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$totalRange((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$totalRange(null);
                }
            } else if (name.equals("totalMonth")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$totalMonth((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$totalMonth(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.example.pro.rumahcemara.models.Dashboard copyOrUpdate(Realm realm, com.example.pro.rumahcemara.models.Dashboard object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.example.pro.rumahcemara.models.Dashboard) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.example.pro.rumahcemara.models.Dashboard copy(Realm realm, com.example.pro.rumahcemara.models.Dashboard newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.pro.rumahcemara.models.Dashboard) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.example.pro.rumahcemara.models.Dashboard realmObject = realm.createObjectInternal(com.example.pro.rumahcemara.models.Dashboard.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_example_pro_rumahcemara_models_DashboardRealmProxyInterface realmObjectSource = (com_example_pro_rumahcemara_models_DashboardRealmProxyInterface) newObject;
        com_example_pro_rumahcemara_models_DashboardRealmProxyInterface realmObjectCopy = (com_example_pro_rumahcemara_models_DashboardRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$totalRange(realmObjectSource.realmGet$totalRange());
        realmObjectCopy.realmSet$totalMonth(realmObjectSource.realmGet$totalMonth());
        return realmObject;
    }

    public static long insert(Realm realm, com.example.pro.rumahcemara.models.Dashboard object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.pro.rumahcemara.models.Dashboard.class);
        long tableNativePtr = table.getNativePtr();
        DashboardColumnInfo columnInfo = (DashboardColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Dashboard.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$totalRange = ((com_example_pro_rumahcemara_models_DashboardRealmProxyInterface) object).realmGet$totalRange();
        if (realmGet$totalRange != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.totalRangeIndex, rowIndex, realmGet$totalRange, false);
        }
        String realmGet$totalMonth = ((com_example_pro_rumahcemara_models_DashboardRealmProxyInterface) object).realmGet$totalMonth();
        if (realmGet$totalMonth != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.totalMonthIndex, rowIndex, realmGet$totalMonth, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.pro.rumahcemara.models.Dashboard.class);
        long tableNativePtr = table.getNativePtr();
        DashboardColumnInfo columnInfo = (DashboardColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Dashboard.class);
        com.example.pro.rumahcemara.models.Dashboard object = null;
        while (objects.hasNext()) {
            object = (com.example.pro.rumahcemara.models.Dashboard) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$totalRange = ((com_example_pro_rumahcemara_models_DashboardRealmProxyInterface) object).realmGet$totalRange();
            if (realmGet$totalRange != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.totalRangeIndex, rowIndex, realmGet$totalRange, false);
            }
            String realmGet$totalMonth = ((com_example_pro_rumahcemara_models_DashboardRealmProxyInterface) object).realmGet$totalMonth();
            if (realmGet$totalMonth != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.totalMonthIndex, rowIndex, realmGet$totalMonth, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.pro.rumahcemara.models.Dashboard object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.pro.rumahcemara.models.Dashboard.class);
        long tableNativePtr = table.getNativePtr();
        DashboardColumnInfo columnInfo = (DashboardColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Dashboard.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$totalRange = ((com_example_pro_rumahcemara_models_DashboardRealmProxyInterface) object).realmGet$totalRange();
        if (realmGet$totalRange != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.totalRangeIndex, rowIndex, realmGet$totalRange, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.totalRangeIndex, rowIndex, false);
        }
        String realmGet$totalMonth = ((com_example_pro_rumahcemara_models_DashboardRealmProxyInterface) object).realmGet$totalMonth();
        if (realmGet$totalMonth != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.totalMonthIndex, rowIndex, realmGet$totalMonth, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.totalMonthIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.pro.rumahcemara.models.Dashboard.class);
        long tableNativePtr = table.getNativePtr();
        DashboardColumnInfo columnInfo = (DashboardColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Dashboard.class);
        com.example.pro.rumahcemara.models.Dashboard object = null;
        while (objects.hasNext()) {
            object = (com.example.pro.rumahcemara.models.Dashboard) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$totalRange = ((com_example_pro_rumahcemara_models_DashboardRealmProxyInterface) object).realmGet$totalRange();
            if (realmGet$totalRange != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.totalRangeIndex, rowIndex, realmGet$totalRange, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.totalRangeIndex, rowIndex, false);
            }
            String realmGet$totalMonth = ((com_example_pro_rumahcemara_models_DashboardRealmProxyInterface) object).realmGet$totalMonth();
            if (realmGet$totalMonth != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.totalMonthIndex, rowIndex, realmGet$totalMonth, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.totalMonthIndex, rowIndex, false);
            }
        }
    }

    public static com.example.pro.rumahcemara.models.Dashboard createDetachedCopy(com.example.pro.rumahcemara.models.Dashboard realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.pro.rumahcemara.models.Dashboard unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.pro.rumahcemara.models.Dashboard();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.pro.rumahcemara.models.Dashboard) cachedObject.object;
            }
            unmanagedObject = (com.example.pro.rumahcemara.models.Dashboard) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_pro_rumahcemara_models_DashboardRealmProxyInterface unmanagedCopy = (com_example_pro_rumahcemara_models_DashboardRealmProxyInterface) unmanagedObject;
        com_example_pro_rumahcemara_models_DashboardRealmProxyInterface realmSource = (com_example_pro_rumahcemara_models_DashboardRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$totalRange(realmSource.realmGet$totalRange());
        unmanagedCopy.realmSet$totalMonth(realmSource.realmGet$totalMonth());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Dashboard = proxy[");
        stringBuilder.append("{totalRange:");
        stringBuilder.append(realmGet$totalRange() != null ? realmGet$totalRange() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalMonth:");
        stringBuilder.append(realmGet$totalMonth() != null ? realmGet$totalMonth() : "null");
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
        com_example_pro_rumahcemara_models_DashboardRealmProxy aDashboard = (com_example_pro_rumahcemara_models_DashboardRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aDashboard.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aDashboard.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aDashboard.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
