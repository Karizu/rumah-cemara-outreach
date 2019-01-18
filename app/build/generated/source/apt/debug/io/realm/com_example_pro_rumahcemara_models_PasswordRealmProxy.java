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
public class com_example_pro_rumahcemara_models_PasswordRealmProxy extends com.example.pro.rumahcemara.models.Password
    implements RealmObjectProxy, com_example_pro_rumahcemara_models_PasswordRealmProxyInterface {

    static final class PasswordColumnInfo extends ColumnInfo {
        long passwordIndex;
        long newPasswordIndex;

        PasswordColumnInfo(OsSchemaInfo schemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Password");
            this.passwordIndex = addColumnDetails("password", "password", objectSchemaInfo);
            this.newPasswordIndex = addColumnDetails("newPassword", "newPassword", objectSchemaInfo);
        }

        PasswordColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PasswordColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PasswordColumnInfo src = (PasswordColumnInfo) rawSrc;
            final PasswordColumnInfo dst = (PasswordColumnInfo) rawDst;
            dst.passwordIndex = src.passwordIndex;
            dst.newPasswordIndex = src.newPasswordIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PasswordColumnInfo columnInfo;
    private ProxyState<com.example.pro.rumahcemara.models.Password> proxyState;

    com_example_pro_rumahcemara_models_PasswordRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PasswordColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.pro.rumahcemara.models.Password>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$password() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.passwordIndex);
    }

    @Override
    public void realmSet$password(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.passwordIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.passwordIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.passwordIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.passwordIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$newPassword() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.newPasswordIndex);
    }

    @Override
    public void realmSet$newPassword(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.newPasswordIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.newPasswordIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.newPasswordIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.newPasswordIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Password", 2, 0);
        builder.addPersistedProperty("password", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("newPassword", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PasswordColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PasswordColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Password";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Password";
    }

    @SuppressWarnings("cast")
    public static com.example.pro.rumahcemara.models.Password createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.pro.rumahcemara.models.Password obj = realm.createObjectInternal(com.example.pro.rumahcemara.models.Password.class, true, excludeFields);

        final com_example_pro_rumahcemara_models_PasswordRealmProxyInterface objProxy = (com_example_pro_rumahcemara_models_PasswordRealmProxyInterface) obj;
        if (json.has("password")) {
            if (json.isNull("password")) {
                objProxy.realmSet$password(null);
            } else {
                objProxy.realmSet$password((String) json.getString("password"));
            }
        }
        if (json.has("newPassword")) {
            if (json.isNull("newPassword")) {
                objProxy.realmSet$newPassword(null);
            } else {
                objProxy.realmSet$newPassword((String) json.getString("newPassword"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.pro.rumahcemara.models.Password createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.example.pro.rumahcemara.models.Password obj = new com.example.pro.rumahcemara.models.Password();
        final com_example_pro_rumahcemara_models_PasswordRealmProxyInterface objProxy = (com_example_pro_rumahcemara_models_PasswordRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("password")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$password((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$password(null);
                }
            } else if (name.equals("newPassword")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$newPassword((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$newPassword(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.example.pro.rumahcemara.models.Password copyOrUpdate(Realm realm, com.example.pro.rumahcemara.models.Password object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.example.pro.rumahcemara.models.Password) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.example.pro.rumahcemara.models.Password copy(Realm realm, com.example.pro.rumahcemara.models.Password newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.pro.rumahcemara.models.Password) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.example.pro.rumahcemara.models.Password realmObject = realm.createObjectInternal(com.example.pro.rumahcemara.models.Password.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_example_pro_rumahcemara_models_PasswordRealmProxyInterface realmObjectSource = (com_example_pro_rumahcemara_models_PasswordRealmProxyInterface) newObject;
        com_example_pro_rumahcemara_models_PasswordRealmProxyInterface realmObjectCopy = (com_example_pro_rumahcemara_models_PasswordRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$password(realmObjectSource.realmGet$password());
        realmObjectCopy.realmSet$newPassword(realmObjectSource.realmGet$newPassword());
        return realmObject;
    }

    public static long insert(Realm realm, com.example.pro.rumahcemara.models.Password object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.pro.rumahcemara.models.Password.class);
        long tableNativePtr = table.getNativePtr();
        PasswordColumnInfo columnInfo = (PasswordColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Password.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$password = ((com_example_pro_rumahcemara_models_PasswordRealmProxyInterface) object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
        }
        String realmGet$newPassword = ((com_example_pro_rumahcemara_models_PasswordRealmProxyInterface) object).realmGet$newPassword();
        if (realmGet$newPassword != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.newPasswordIndex, rowIndex, realmGet$newPassword, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.pro.rumahcemara.models.Password.class);
        long tableNativePtr = table.getNativePtr();
        PasswordColumnInfo columnInfo = (PasswordColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Password.class);
        com.example.pro.rumahcemara.models.Password object = null;
        while (objects.hasNext()) {
            object = (com.example.pro.rumahcemara.models.Password) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$password = ((com_example_pro_rumahcemara_models_PasswordRealmProxyInterface) object).realmGet$password();
            if (realmGet$password != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
            }
            String realmGet$newPassword = ((com_example_pro_rumahcemara_models_PasswordRealmProxyInterface) object).realmGet$newPassword();
            if (realmGet$newPassword != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.newPasswordIndex, rowIndex, realmGet$newPassword, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.pro.rumahcemara.models.Password object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.pro.rumahcemara.models.Password.class);
        long tableNativePtr = table.getNativePtr();
        PasswordColumnInfo columnInfo = (PasswordColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Password.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$password = ((com_example_pro_rumahcemara_models_PasswordRealmProxyInterface) object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.passwordIndex, rowIndex, false);
        }
        String realmGet$newPassword = ((com_example_pro_rumahcemara_models_PasswordRealmProxyInterface) object).realmGet$newPassword();
        if (realmGet$newPassword != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.newPasswordIndex, rowIndex, realmGet$newPassword, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.newPasswordIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.pro.rumahcemara.models.Password.class);
        long tableNativePtr = table.getNativePtr();
        PasswordColumnInfo columnInfo = (PasswordColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Password.class);
        com.example.pro.rumahcemara.models.Password object = null;
        while (objects.hasNext()) {
            object = (com.example.pro.rumahcemara.models.Password) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$password = ((com_example_pro_rumahcemara_models_PasswordRealmProxyInterface) object).realmGet$password();
            if (realmGet$password != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.passwordIndex, rowIndex, false);
            }
            String realmGet$newPassword = ((com_example_pro_rumahcemara_models_PasswordRealmProxyInterface) object).realmGet$newPassword();
            if (realmGet$newPassword != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.newPasswordIndex, rowIndex, realmGet$newPassword, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.newPasswordIndex, rowIndex, false);
            }
        }
    }

    public static com.example.pro.rumahcemara.models.Password createDetachedCopy(com.example.pro.rumahcemara.models.Password realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.pro.rumahcemara.models.Password unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.pro.rumahcemara.models.Password();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.pro.rumahcemara.models.Password) cachedObject.object;
            }
            unmanagedObject = (com.example.pro.rumahcemara.models.Password) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_pro_rumahcemara_models_PasswordRealmProxyInterface unmanagedCopy = (com_example_pro_rumahcemara_models_PasswordRealmProxyInterface) unmanagedObject;
        com_example_pro_rumahcemara_models_PasswordRealmProxyInterface realmSource = (com_example_pro_rumahcemara_models_PasswordRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$password(realmSource.realmGet$password());
        unmanagedCopy.realmSet$newPassword(realmSource.realmGet$newPassword());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Password = proxy[");
        stringBuilder.append("{password:");
        stringBuilder.append(realmGet$password() != null ? realmGet$password() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{newPassword:");
        stringBuilder.append(realmGet$newPassword() != null ? realmGet$newPassword() : "null");
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
        com_example_pro_rumahcemara_models_PasswordRealmProxy aPassword = (com_example_pro_rumahcemara_models_PasswordRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPassword.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPassword.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPassword.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
