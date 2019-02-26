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
public class com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxy extends com.boardinglabs.rumahcemara.outreach.models.Register
    implements RealmObjectProxy, com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface {

    static final class RegisterColumnInfo extends ColumnInfo {
        long usernameIndex;
        long passwordIndex;
        long fullnameIndex;
        long phoneNumberIndex;
        long emailIndex;
        long dsoIndex;

        RegisterColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Register");
            this.usernameIndex = addColumnDetails("username", "username", objectSchemaInfo);
            this.passwordIndex = addColumnDetails("password", "password", objectSchemaInfo);
            this.fullnameIndex = addColumnDetails("fullname", "fullname", objectSchemaInfo);
            this.phoneNumberIndex = addColumnDetails("phoneNumber", "phoneNumber", objectSchemaInfo);
            this.emailIndex = addColumnDetails("email", "email", objectSchemaInfo);
            this.dsoIndex = addColumnDetails("dso", "dso", objectSchemaInfo);
        }

        RegisterColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RegisterColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RegisterColumnInfo src = (RegisterColumnInfo) rawSrc;
            final RegisterColumnInfo dst = (RegisterColumnInfo) rawDst;
            dst.usernameIndex = src.usernameIndex;
            dst.passwordIndex = src.passwordIndex;
            dst.fullnameIndex = src.fullnameIndex;
            dst.phoneNumberIndex = src.phoneNumberIndex;
            dst.emailIndex = src.emailIndex;
            dst.dsoIndex = src.dsoIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private RegisterColumnInfo columnInfo;
    private ProxyState<com.boardinglabs.rumahcemara.outreach.models.Register> proxyState;

    com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RegisterColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.boardinglabs.rumahcemara.outreach.models.Register>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$username() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.usernameIndex);
    }

    @Override
    public void realmSet$username(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.usernameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.usernameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.usernameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.usernameIndex, value);
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
    public String realmGet$fullname() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fullnameIndex);
    }

    @Override
    public void realmSet$fullname(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fullnameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fullnameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fullnameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fullnameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$phoneNumber() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.phoneNumberIndex);
    }

    @Override
    public void realmSet$phoneNumber(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.phoneNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.phoneNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.phoneNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.phoneNumberIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$email() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.emailIndex);
    }

    @Override
    public void realmSet$email(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.emailIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.emailIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.emailIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.emailIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$dso() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.dsoIndex);
    }

    @Override
    public void realmSet$dso(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.dsoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.dsoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.dsoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.dsoIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Register", 6, 0);
        builder.addPersistedProperty("username", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("password", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("fullname", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("phoneNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("email", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("dso", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RegisterColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RegisterColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Register";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Register";
    }

    @SuppressWarnings("cast")
    public static com.boardinglabs.rumahcemara.outreach.models.Register createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.boardinglabs.rumahcemara.outreach.models.Register obj = realm.createObjectInternal(com.boardinglabs.rumahcemara.outreach.models.Register.class, true, excludeFields);

        final com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface objProxy = (com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) obj;
        if (json.has("username")) {
            if (json.isNull("username")) {
                objProxy.realmSet$username(null);
            } else {
                objProxy.realmSet$username((String) json.getString("username"));
            }
        }
        if (json.has("password")) {
            if (json.isNull("password")) {
                objProxy.realmSet$password(null);
            } else {
                objProxy.realmSet$password((String) json.getString("password"));
            }
        }
        if (json.has("fullname")) {
            if (json.isNull("fullname")) {
                objProxy.realmSet$fullname(null);
            } else {
                objProxy.realmSet$fullname((String) json.getString("fullname"));
            }
        }
        if (json.has("phoneNumber")) {
            if (json.isNull("phoneNumber")) {
                objProxy.realmSet$phoneNumber(null);
            } else {
                objProxy.realmSet$phoneNumber((String) json.getString("phoneNumber"));
            }
        }
        if (json.has("email")) {
            if (json.isNull("email")) {
                objProxy.realmSet$email(null);
            } else {
                objProxy.realmSet$email((String) json.getString("email"));
            }
        }
        if (json.has("dso")) {
            if (json.isNull("dso")) {
                objProxy.realmSet$dso(null);
            } else {
                objProxy.realmSet$dso((String) json.getString("dso"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.boardinglabs.rumahcemara.outreach.models.Register createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.boardinglabs.rumahcemara.outreach.models.Register obj = new com.boardinglabs.rumahcemara.outreach.models.Register();
        final com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface objProxy = (com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("username")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$username((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$username(null);
                }
            } else if (name.equals("password")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$password((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$password(null);
                }
            } else if (name.equals("fullname")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fullname((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fullname(null);
                }
            } else if (name.equals("phoneNumber")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$phoneNumber((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$phoneNumber(null);
                }
            } else if (name.equals("email")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$email((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$email(null);
                }
            } else if (name.equals("dso")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$dso((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$dso(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.boardinglabs.rumahcemara.outreach.models.Register copyOrUpdate(Realm realm, com.boardinglabs.rumahcemara.outreach.models.Register object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.boardinglabs.rumahcemara.outreach.models.Register) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.boardinglabs.rumahcemara.outreach.models.Register copy(Realm realm, com.boardinglabs.rumahcemara.outreach.models.Register newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.boardinglabs.rumahcemara.outreach.models.Register) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.boardinglabs.rumahcemara.outreach.models.Register realmObject = realm.createObjectInternal(com.boardinglabs.rumahcemara.outreach.models.Register.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface realmObjectSource = (com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) newObject;
        com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface realmObjectCopy = (com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$username(realmObjectSource.realmGet$username());
        realmObjectCopy.realmSet$password(realmObjectSource.realmGet$password());
        realmObjectCopy.realmSet$fullname(realmObjectSource.realmGet$fullname());
        realmObjectCopy.realmSet$phoneNumber(realmObjectSource.realmGet$phoneNumber());
        realmObjectCopy.realmSet$email(realmObjectSource.realmGet$email());
        realmObjectCopy.realmSet$dso(realmObjectSource.realmGet$dso());
        return realmObject;
    }

    public static long insert(Realm realm, com.boardinglabs.rumahcemara.outreach.models.Register object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.boardinglabs.rumahcemara.outreach.models.Register.class);
        long tableNativePtr = table.getNativePtr();
        RegisterColumnInfo columnInfo = (RegisterColumnInfo) realm.getSchema().getColumnInfo(com.boardinglabs.rumahcemara.outreach.models.Register.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$username = ((com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) object).realmGet$username();
        if (realmGet$username != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
        }
        String realmGet$password = ((com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
        }
        String realmGet$fullname = ((com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) object).realmGet$fullname();
        if (realmGet$fullname != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fullnameIndex, rowIndex, realmGet$fullname, false);
        }
        String realmGet$phoneNumber = ((com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) object).realmGet$phoneNumber();
        if (realmGet$phoneNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.phoneNumberIndex, rowIndex, realmGet$phoneNumber, false);
        }
        String realmGet$email = ((com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        }
        String realmGet$dso = ((com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) object).realmGet$dso();
        if (realmGet$dso != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dsoIndex, rowIndex, realmGet$dso, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.boardinglabs.rumahcemara.outreach.models.Register.class);
        long tableNativePtr = table.getNativePtr();
        RegisterColumnInfo columnInfo = (RegisterColumnInfo) realm.getSchema().getColumnInfo(com.boardinglabs.rumahcemara.outreach.models.Register.class);
        com.boardinglabs.rumahcemara.outreach.models.Register object = null;
        while (objects.hasNext()) {
            object = (com.boardinglabs.rumahcemara.outreach.models.Register) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$username = ((com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) object).realmGet$username();
            if (realmGet$username != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
            }
            String realmGet$password = ((com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) object).realmGet$password();
            if (realmGet$password != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
            }
            String realmGet$fullname = ((com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) object).realmGet$fullname();
            if (realmGet$fullname != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fullnameIndex, rowIndex, realmGet$fullname, false);
            }
            String realmGet$phoneNumber = ((com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) object).realmGet$phoneNumber();
            if (realmGet$phoneNumber != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.phoneNumberIndex, rowIndex, realmGet$phoneNumber, false);
            }
            String realmGet$email = ((com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) object).realmGet$email();
            if (realmGet$email != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
            }
            String realmGet$dso = ((com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) object).realmGet$dso();
            if (realmGet$dso != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.dsoIndex, rowIndex, realmGet$dso, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.boardinglabs.rumahcemara.outreach.models.Register object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.boardinglabs.rumahcemara.outreach.models.Register.class);
        long tableNativePtr = table.getNativePtr();
        RegisterColumnInfo columnInfo = (RegisterColumnInfo) realm.getSchema().getColumnInfo(com.boardinglabs.rumahcemara.outreach.models.Register.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$username = ((com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) object).realmGet$username();
        if (realmGet$username != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.usernameIndex, rowIndex, false);
        }
        String realmGet$password = ((com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.passwordIndex, rowIndex, false);
        }
        String realmGet$fullname = ((com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) object).realmGet$fullname();
        if (realmGet$fullname != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fullnameIndex, rowIndex, realmGet$fullname, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fullnameIndex, rowIndex, false);
        }
        String realmGet$phoneNumber = ((com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) object).realmGet$phoneNumber();
        if (realmGet$phoneNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.phoneNumberIndex, rowIndex, realmGet$phoneNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.phoneNumberIndex, rowIndex, false);
        }
        String realmGet$email = ((com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
        }
        String realmGet$dso = ((com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) object).realmGet$dso();
        if (realmGet$dso != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dsoIndex, rowIndex, realmGet$dso, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.dsoIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.boardinglabs.rumahcemara.outreach.models.Register.class);
        long tableNativePtr = table.getNativePtr();
        RegisterColumnInfo columnInfo = (RegisterColumnInfo) realm.getSchema().getColumnInfo(com.boardinglabs.rumahcemara.outreach.models.Register.class);
        com.boardinglabs.rumahcemara.outreach.models.Register object = null;
        while (objects.hasNext()) {
            object = (com.boardinglabs.rumahcemara.outreach.models.Register) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$username = ((com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) object).realmGet$username();
            if (realmGet$username != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.usernameIndex, rowIndex, false);
            }
            String realmGet$password = ((com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) object).realmGet$password();
            if (realmGet$password != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.passwordIndex, rowIndex, false);
            }
            String realmGet$fullname = ((com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) object).realmGet$fullname();
            if (realmGet$fullname != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fullnameIndex, rowIndex, realmGet$fullname, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fullnameIndex, rowIndex, false);
            }
            String realmGet$phoneNumber = ((com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) object).realmGet$phoneNumber();
            if (realmGet$phoneNumber != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.phoneNumberIndex, rowIndex, realmGet$phoneNumber, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.phoneNumberIndex, rowIndex, false);
            }
            String realmGet$email = ((com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) object).realmGet$email();
            if (realmGet$email != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
            }
            String realmGet$dso = ((com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) object).realmGet$dso();
            if (realmGet$dso != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.dsoIndex, rowIndex, realmGet$dso, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.dsoIndex, rowIndex, false);
            }
        }
    }

    public static com.boardinglabs.rumahcemara.outreach.models.Register createDetachedCopy(com.boardinglabs.rumahcemara.outreach.models.Register realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.boardinglabs.rumahcemara.outreach.models.Register unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.boardinglabs.rumahcemara.outreach.models.Register();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.boardinglabs.rumahcemara.outreach.models.Register) cachedObject.object;
            }
            unmanagedObject = (com.boardinglabs.rumahcemara.outreach.models.Register) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface unmanagedCopy = (com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) unmanagedObject;
        com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface realmSource = (com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$username(realmSource.realmGet$username());
        unmanagedCopy.realmSet$password(realmSource.realmGet$password());
        unmanagedCopy.realmSet$fullname(realmSource.realmGet$fullname());
        unmanagedCopy.realmSet$phoneNumber(realmSource.realmGet$phoneNumber());
        unmanagedCopy.realmSet$email(realmSource.realmGet$email());
        unmanagedCopy.realmSet$dso(realmSource.realmGet$dso());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Register = proxy[");
        stringBuilder.append("{username:");
        stringBuilder.append(realmGet$username() != null ? realmGet$username() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{password:");
        stringBuilder.append(realmGet$password() != null ? realmGet$password() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fullname:");
        stringBuilder.append(realmGet$fullname() != null ? realmGet$fullname() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{phoneNumber:");
        stringBuilder.append(realmGet$phoneNumber() != null ? realmGet$phoneNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{email:");
        stringBuilder.append(realmGet$email() != null ? realmGet$email() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{dso:");
        stringBuilder.append(realmGet$dso() != null ? realmGet$dso() : "null");
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
        com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxy aRegister = (com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aRegister.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRegister.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aRegister.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
