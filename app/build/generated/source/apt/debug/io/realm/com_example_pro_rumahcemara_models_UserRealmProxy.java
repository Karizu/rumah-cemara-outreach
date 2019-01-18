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
public class com_example_pro_rumahcemara_models_UserRealmProxy extends com.example.pro.rumahcemara.models.User
    implements RealmObjectProxy, com_example_pro_rumahcemara_models_UserRealmProxyInterface {

    static final class UserColumnInfo extends ColumnInfo {
        long usernameIndex;
        long emailIndex;
        long passwordIndex;
        long idIndex;
        long roleIdIndex;
        long statusIndex;
        long createdAtIndex;
        long updatedAtIndex;
        long deletedAtIndex;
        long profileIndex;

        UserColumnInfo(OsSchemaInfo schemaInfo) {
            super(10);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("User");
            this.usernameIndex = addColumnDetails("username", "username", objectSchemaInfo);
            this.emailIndex = addColumnDetails("email", "email", objectSchemaInfo);
            this.passwordIndex = addColumnDetails("password", "password", objectSchemaInfo);
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.roleIdIndex = addColumnDetails("roleId", "roleId", objectSchemaInfo);
            this.statusIndex = addColumnDetails("status", "status", objectSchemaInfo);
            this.createdAtIndex = addColumnDetails("createdAt", "createdAt", objectSchemaInfo);
            this.updatedAtIndex = addColumnDetails("updatedAt", "updatedAt", objectSchemaInfo);
            this.deletedAtIndex = addColumnDetails("deletedAt", "deletedAt", objectSchemaInfo);
            this.profileIndex = addColumnDetails("profile", "profile", objectSchemaInfo);
        }

        UserColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new UserColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final UserColumnInfo src = (UserColumnInfo) rawSrc;
            final UserColumnInfo dst = (UserColumnInfo) rawDst;
            dst.usernameIndex = src.usernameIndex;
            dst.emailIndex = src.emailIndex;
            dst.passwordIndex = src.passwordIndex;
            dst.idIndex = src.idIndex;
            dst.roleIdIndex = src.roleIdIndex;
            dst.statusIndex = src.statusIndex;
            dst.createdAtIndex = src.createdAtIndex;
            dst.updatedAtIndex = src.updatedAtIndex;
            dst.deletedAtIndex = src.deletedAtIndex;
            dst.profileIndex = src.profileIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private UserColumnInfo columnInfo;
    private ProxyState<com.example.pro.rumahcemara.models.User> proxyState;

    com_example_pro_rumahcemara_models_UserRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UserColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.pro.rumahcemara.models.User>(this);
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
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$roleId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.roleIdIndex);
    }

    @Override
    public void realmSet$roleId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.roleIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.roleIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.roleIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.roleIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$status() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.statusIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.statusIndex);
    }

    @Override
    public void realmSet$status(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.statusIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.statusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.statusIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.statusIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$createdAt() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.createdAtIndex);
    }

    @Override
    public void realmSet$createdAt(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.createdAtIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.createdAtIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.createdAtIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.createdAtIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$updatedAt() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.updatedAtIndex);
    }

    @Override
    public void realmSet$updatedAt(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.updatedAtIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.updatedAtIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.updatedAtIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.updatedAtIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$deletedAt() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.deletedAtIndex);
    }

    @Override
    public void realmSet$deletedAt(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.deletedAtIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.deletedAtIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.deletedAtIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.deletedAtIndex, value);
    }

    @Override
    public com.example.pro.rumahcemara.models.Profile realmGet$profile() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.profileIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.pro.rumahcemara.models.Profile.class, proxyState.getRow$realm().getLink(columnInfo.profileIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$profile(com.example.pro.rumahcemara.models.Profile value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("profile")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.profileIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.profileIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.profileIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.profileIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("User", 10, 0);
        builder.addPersistedProperty("username", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("email", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("password", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("roleId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("status", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("createdAt", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("updatedAt", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("deletedAt", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("profile", RealmFieldType.OBJECT, "Profile");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static UserColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new UserColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "User";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "User";
    }

    @SuppressWarnings("cast")
    public static com.example.pro.rumahcemara.models.User createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.example.pro.rumahcemara.models.User obj = null;
        if (update) {
            Table table = realm.getTable(com.example.pro.rumahcemara.models.User.class);
            UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.User.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.User.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_example_pro_rumahcemara_models_UserRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("profile")) {
                excludeFields.add("profile");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_example_pro_rumahcemara_models_UserRealmProxy) realm.createObjectInternal(com.example.pro.rumahcemara.models.User.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_example_pro_rumahcemara_models_UserRealmProxy) realm.createObjectInternal(com.example.pro.rumahcemara.models.User.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_example_pro_rumahcemara_models_UserRealmProxyInterface objProxy = (com_example_pro_rumahcemara_models_UserRealmProxyInterface) obj;
        if (json.has("username")) {
            if (json.isNull("username")) {
                objProxy.realmSet$username(null);
            } else {
                objProxy.realmSet$username((String) json.getString("username"));
            }
        }
        if (json.has("email")) {
            if (json.isNull("email")) {
                objProxy.realmSet$email(null);
            } else {
                objProxy.realmSet$email((String) json.getString("email"));
            }
        }
        if (json.has("password")) {
            if (json.isNull("password")) {
                objProxy.realmSet$password(null);
            } else {
                objProxy.realmSet$password((String) json.getString("password"));
            }
        }
        if (json.has("roleId")) {
            if (json.isNull("roleId")) {
                objProxy.realmSet$roleId(null);
            } else {
                objProxy.realmSet$roleId((String) json.getString("roleId"));
            }
        }
        if (json.has("status")) {
            if (json.isNull("status")) {
                objProxy.realmSet$status(null);
            } else {
                objProxy.realmSet$status((int) json.getInt("status"));
            }
        }
        if (json.has("createdAt")) {
            if (json.isNull("createdAt")) {
                objProxy.realmSet$createdAt(null);
            } else {
                objProxy.realmSet$createdAt((String) json.getString("createdAt"));
            }
        }
        if (json.has("updatedAt")) {
            if (json.isNull("updatedAt")) {
                objProxy.realmSet$updatedAt(null);
            } else {
                objProxy.realmSet$updatedAt((String) json.getString("updatedAt"));
            }
        }
        if (json.has("deletedAt")) {
            if (json.isNull("deletedAt")) {
                objProxy.realmSet$deletedAt(null);
            } else {
                objProxy.realmSet$deletedAt((String) json.getString("deletedAt"));
            }
        }
        if (json.has("profile")) {
            if (json.isNull("profile")) {
                objProxy.realmSet$profile(null);
            } else {
                com.example.pro.rumahcemara.models.Profile profileObj = com_example_pro_rumahcemara_models_ProfileRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("profile"), update);
                objProxy.realmSet$profile(profileObj);
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.pro.rumahcemara.models.User createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.example.pro.rumahcemara.models.User obj = new com.example.pro.rumahcemara.models.User();
        final com_example_pro_rumahcemara_models_UserRealmProxyInterface objProxy = (com_example_pro_rumahcemara_models_UserRealmProxyInterface) obj;
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
            } else if (name.equals("email")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$email((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$email(null);
                }
            } else if (name.equals("password")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$password((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$password(null);
                }
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("roleId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$roleId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$roleId(null);
                }
            } else if (name.equals("status")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$status((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$status(null);
                }
            } else if (name.equals("createdAt")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$createdAt((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$createdAt(null);
                }
            } else if (name.equals("updatedAt")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$updatedAt((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$updatedAt(null);
                }
            } else if (name.equals("deletedAt")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$deletedAt((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$deletedAt(null);
                }
            } else if (name.equals("profile")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$profile(null);
                } else {
                    com.example.pro.rumahcemara.models.Profile profileObj = com_example_pro_rumahcemara_models_ProfileRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$profile(profileObj);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.example.pro.rumahcemara.models.User copyOrUpdate(Realm realm, com.example.pro.rumahcemara.models.User object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.example.pro.rumahcemara.models.User) cachedRealmObject;
        }

        com.example.pro.rumahcemara.models.User realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.example.pro.rumahcemara.models.User.class);
            UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.User.class);
            long pkColumnIndex = columnInfo.idIndex;
            String value = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (value == null) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, value);
            }
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.User.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_example_pro_rumahcemara_models_UserRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.example.pro.rumahcemara.models.User copy(Realm realm, com.example.pro.rumahcemara.models.User newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.pro.rumahcemara.models.User) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.example.pro.rumahcemara.models.User realmObject = realm.createObjectInternal(com.example.pro.rumahcemara.models.User.class, ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_example_pro_rumahcemara_models_UserRealmProxyInterface realmObjectSource = (com_example_pro_rumahcemara_models_UserRealmProxyInterface) newObject;
        com_example_pro_rumahcemara_models_UserRealmProxyInterface realmObjectCopy = (com_example_pro_rumahcemara_models_UserRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$username(realmObjectSource.realmGet$username());
        realmObjectCopy.realmSet$email(realmObjectSource.realmGet$email());
        realmObjectCopy.realmSet$password(realmObjectSource.realmGet$password());
        realmObjectCopy.realmSet$roleId(realmObjectSource.realmGet$roleId());
        realmObjectCopy.realmSet$status(realmObjectSource.realmGet$status());
        realmObjectCopy.realmSet$createdAt(realmObjectSource.realmGet$createdAt());
        realmObjectCopy.realmSet$updatedAt(realmObjectSource.realmGet$updatedAt());
        realmObjectCopy.realmSet$deletedAt(realmObjectSource.realmGet$deletedAt());

        com.example.pro.rumahcemara.models.Profile profileObj = realmObjectSource.realmGet$profile();
        if (profileObj == null) {
            realmObjectCopy.realmSet$profile(null);
        } else {
            com.example.pro.rumahcemara.models.Profile cacheprofile = (com.example.pro.rumahcemara.models.Profile) cache.get(profileObj);
            if (cacheprofile != null) {
                realmObjectCopy.realmSet$profile(cacheprofile);
            } else {
                realmObjectCopy.realmSet$profile(com_example_pro_rumahcemara_models_ProfileRealmProxy.copyOrUpdate(realm, profileObj, update, cache));
            }
        }
        return realmObject;
    }

    public static long insert(Realm realm, com.example.pro.rumahcemara.models.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.pro.rumahcemara.models.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.User.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$username = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$username();
        if (realmGet$username != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
        }
        String realmGet$email = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        }
        String realmGet$password = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
        }
        String realmGet$roleId = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$roleId();
        if (realmGet$roleId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.roleIdIndex, rowIndex, realmGet$roleId, false);
        }
        Number realmGet$status = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status.longValue(), false);
        }
        String realmGet$createdAt = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$createdAt();
        if (realmGet$createdAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
        }
        String realmGet$updatedAt = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$updatedAt();
        if (realmGet$updatedAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
        }
        String realmGet$deletedAt = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$deletedAt();
        if (realmGet$deletedAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, realmGet$deletedAt, false);
        }

        com.example.pro.rumahcemara.models.Profile profileObj = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$profile();
        if (profileObj != null) {
            Long cacheprofile = cache.get(profileObj);
            if (cacheprofile == null) {
                cacheprofile = com_example_pro_rumahcemara_models_ProfileRealmProxy.insert(realm, profileObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.profileIndex, rowIndex, cacheprofile, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.pro.rumahcemara.models.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.User.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.example.pro.rumahcemara.models.User object = null;
        while (objects.hasNext()) {
            object = (com.example.pro.rumahcemara.models.User) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$username = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$username();
            if (realmGet$username != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
            }
            String realmGet$email = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$email();
            if (realmGet$email != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
            }
            String realmGet$password = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$password();
            if (realmGet$password != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
            }
            String realmGet$roleId = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$roleId();
            if (realmGet$roleId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.roleIdIndex, rowIndex, realmGet$roleId, false);
            }
            Number realmGet$status = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status.longValue(), false);
            }
            String realmGet$createdAt = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$createdAt();
            if (realmGet$createdAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
            }
            String realmGet$updatedAt = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$updatedAt();
            if (realmGet$updatedAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
            }
            String realmGet$deletedAt = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$deletedAt();
            if (realmGet$deletedAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, realmGet$deletedAt, false);
            }

            com.example.pro.rumahcemara.models.Profile profileObj = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$profile();
            if (profileObj != null) {
                Long cacheprofile = cache.get(profileObj);
                if (cacheprofile == null) {
                    cacheprofile = com_example_pro_rumahcemara_models_ProfileRealmProxy.insert(realm, profileObj, cache);
                }
                table.setLink(columnInfo.profileIndex, rowIndex, cacheprofile, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.pro.rumahcemara.models.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.pro.rumahcemara.models.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.User.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$username = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$username();
        if (realmGet$username != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.usernameIndex, rowIndex, false);
        }
        String realmGet$email = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
        }
        String realmGet$password = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.passwordIndex, rowIndex, false);
        }
        String realmGet$roleId = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$roleId();
        if (realmGet$roleId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.roleIdIndex, rowIndex, realmGet$roleId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.roleIdIndex, rowIndex, false);
        }
        Number realmGet$status = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
        }
        String realmGet$createdAt = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$createdAt();
        if (realmGet$createdAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.createdAtIndex, rowIndex, false);
        }
        String realmGet$updatedAt = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$updatedAt();
        if (realmGet$updatedAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, false);
        }
        String realmGet$deletedAt = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$deletedAt();
        if (realmGet$deletedAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, realmGet$deletedAt, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, false);
        }

        com.example.pro.rumahcemara.models.Profile profileObj = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$profile();
        if (profileObj != null) {
            Long cacheprofile = cache.get(profileObj);
            if (cacheprofile == null) {
                cacheprofile = com_example_pro_rumahcemara_models_ProfileRealmProxy.insertOrUpdate(realm, profileObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.profileIndex, rowIndex, cacheprofile, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.profileIndex, rowIndex);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.pro.rumahcemara.models.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.User.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.example.pro.rumahcemara.models.User object = null;
        while (objects.hasNext()) {
            object = (com.example.pro.rumahcemara.models.User) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$username = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$username();
            if (realmGet$username != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.usernameIndex, rowIndex, false);
            }
            String realmGet$email = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$email();
            if (realmGet$email != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
            }
            String realmGet$password = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$password();
            if (realmGet$password != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.passwordIndex, rowIndex, false);
            }
            String realmGet$roleId = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$roleId();
            if (realmGet$roleId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.roleIdIndex, rowIndex, realmGet$roleId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.roleIdIndex, rowIndex, false);
            }
            Number realmGet$status = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
            }
            String realmGet$createdAt = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$createdAt();
            if (realmGet$createdAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.createdAtIndex, rowIndex, false);
            }
            String realmGet$updatedAt = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$updatedAt();
            if (realmGet$updatedAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, false);
            }
            String realmGet$deletedAt = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$deletedAt();
            if (realmGet$deletedAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, realmGet$deletedAt, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, false);
            }

            com.example.pro.rumahcemara.models.Profile profileObj = ((com_example_pro_rumahcemara_models_UserRealmProxyInterface) object).realmGet$profile();
            if (profileObj != null) {
                Long cacheprofile = cache.get(profileObj);
                if (cacheprofile == null) {
                    cacheprofile = com_example_pro_rumahcemara_models_ProfileRealmProxy.insertOrUpdate(realm, profileObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.profileIndex, rowIndex, cacheprofile, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.profileIndex, rowIndex);
            }
        }
    }

    public static com.example.pro.rumahcemara.models.User createDetachedCopy(com.example.pro.rumahcemara.models.User realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.pro.rumahcemara.models.User unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.pro.rumahcemara.models.User();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.pro.rumahcemara.models.User) cachedObject.object;
            }
            unmanagedObject = (com.example.pro.rumahcemara.models.User) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_pro_rumahcemara_models_UserRealmProxyInterface unmanagedCopy = (com_example_pro_rumahcemara_models_UserRealmProxyInterface) unmanagedObject;
        com_example_pro_rumahcemara_models_UserRealmProxyInterface realmSource = (com_example_pro_rumahcemara_models_UserRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$username(realmSource.realmGet$username());
        unmanagedCopy.realmSet$email(realmSource.realmGet$email());
        unmanagedCopy.realmSet$password(realmSource.realmGet$password());
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$roleId(realmSource.realmGet$roleId());
        unmanagedCopy.realmSet$status(realmSource.realmGet$status());
        unmanagedCopy.realmSet$createdAt(realmSource.realmGet$createdAt());
        unmanagedCopy.realmSet$updatedAt(realmSource.realmGet$updatedAt());
        unmanagedCopy.realmSet$deletedAt(realmSource.realmGet$deletedAt());

        // Deep copy of profile
        unmanagedCopy.realmSet$profile(com_example_pro_rumahcemara_models_ProfileRealmProxy.createDetachedCopy(realmSource.realmGet$profile(), currentDepth + 1, maxDepth, cache));

        return unmanagedObject;
    }

    static com.example.pro.rumahcemara.models.User update(Realm realm, com.example.pro.rumahcemara.models.User realmObject, com.example.pro.rumahcemara.models.User newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_example_pro_rumahcemara_models_UserRealmProxyInterface realmObjectTarget = (com_example_pro_rumahcemara_models_UserRealmProxyInterface) realmObject;
        com_example_pro_rumahcemara_models_UserRealmProxyInterface realmObjectSource = (com_example_pro_rumahcemara_models_UserRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$username(realmObjectSource.realmGet$username());
        realmObjectTarget.realmSet$email(realmObjectSource.realmGet$email());
        realmObjectTarget.realmSet$password(realmObjectSource.realmGet$password());
        realmObjectTarget.realmSet$roleId(realmObjectSource.realmGet$roleId());
        realmObjectTarget.realmSet$status(realmObjectSource.realmGet$status());
        realmObjectTarget.realmSet$createdAt(realmObjectSource.realmGet$createdAt());
        realmObjectTarget.realmSet$updatedAt(realmObjectSource.realmGet$updatedAt());
        realmObjectTarget.realmSet$deletedAt(realmObjectSource.realmGet$deletedAt());
        com.example.pro.rumahcemara.models.Profile profileObj = realmObjectSource.realmGet$profile();
        if (profileObj == null) {
            realmObjectTarget.realmSet$profile(null);
        } else {
            com.example.pro.rumahcemara.models.Profile cacheprofile = (com.example.pro.rumahcemara.models.Profile) cache.get(profileObj);
            if (cacheprofile != null) {
                realmObjectTarget.realmSet$profile(cacheprofile);
            } else {
                realmObjectTarget.realmSet$profile(com_example_pro_rumahcemara_models_ProfileRealmProxy.copyOrUpdate(realm, profileObj, true, cache));
            }
        }
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("User = proxy[");
        stringBuilder.append("{username:");
        stringBuilder.append(realmGet$username() != null ? realmGet$username() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{email:");
        stringBuilder.append(realmGet$email() != null ? realmGet$email() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{password:");
        stringBuilder.append(realmGet$password() != null ? realmGet$password() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{roleId:");
        stringBuilder.append(realmGet$roleId() != null ? realmGet$roleId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{status:");
        stringBuilder.append(realmGet$status() != null ? realmGet$status() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{createdAt:");
        stringBuilder.append(realmGet$createdAt() != null ? realmGet$createdAt() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{updatedAt:");
        stringBuilder.append(realmGet$updatedAt() != null ? realmGet$updatedAt() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{deletedAt:");
        stringBuilder.append(realmGet$deletedAt() != null ? realmGet$deletedAt() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{profile:");
        stringBuilder.append(realmGet$profile() != null ? "Profile" : "null");
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
        com_example_pro_rumahcemara_models_UserRealmProxy aUser = (com_example_pro_rumahcemara_models_UserRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aUser.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aUser.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aUser.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
