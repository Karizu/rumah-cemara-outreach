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
public class com_example_pro_rumahcemara_models_GroupRealmProxy extends com.example.pro.rumahcemara.models.Group
    implements RealmObjectProxy, com_example_pro_rumahcemara_models_GroupRealmProxyInterface {

    static final class GroupColumnInfo extends ColumnInfo {
        long idIndex;
        long parentIdIndex;
        long picIndex;
        long nameIndex;
        long addressIndex;
        long pictureIndex;
        long areasIndex;
        long isParentIndex;
        long createdAtIndex;
        long updatedAtIndex;
        long deletedAtIndex;

        GroupColumnInfo(OsSchemaInfo schemaInfo) {
            super(11);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Group");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.parentIdIndex = addColumnDetails("parentId", "parentId", objectSchemaInfo);
            this.picIndex = addColumnDetails("pic", "pic", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", "name", objectSchemaInfo);
            this.addressIndex = addColumnDetails("address", "address", objectSchemaInfo);
            this.pictureIndex = addColumnDetails("picture", "picture", objectSchemaInfo);
            this.areasIndex = addColumnDetails("areas", "areas", objectSchemaInfo);
            this.isParentIndex = addColumnDetails("isParent", "isParent", objectSchemaInfo);
            this.createdAtIndex = addColumnDetails("createdAt", "createdAt", objectSchemaInfo);
            this.updatedAtIndex = addColumnDetails("updatedAt", "updatedAt", objectSchemaInfo);
            this.deletedAtIndex = addColumnDetails("deletedAt", "deletedAt", objectSchemaInfo);
        }

        GroupColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new GroupColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final GroupColumnInfo src = (GroupColumnInfo) rawSrc;
            final GroupColumnInfo dst = (GroupColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.parentIdIndex = src.parentIdIndex;
            dst.picIndex = src.picIndex;
            dst.nameIndex = src.nameIndex;
            dst.addressIndex = src.addressIndex;
            dst.pictureIndex = src.pictureIndex;
            dst.areasIndex = src.areasIndex;
            dst.isParentIndex = src.isParentIndex;
            dst.createdAtIndex = src.createdAtIndex;
            dst.updatedAtIndex = src.updatedAtIndex;
            dst.deletedAtIndex = src.deletedAtIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private GroupColumnInfo columnInfo;
    private ProxyState<com.example.pro.rumahcemara.models.Group> proxyState;

    com_example_pro_rumahcemara_models_GroupRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (GroupColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.pro.rumahcemara.models.Group>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
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
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$parentId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.parentIdIndex);
    }

    @Override
    public void realmSet$parentId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.parentIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.parentIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.parentIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.parentIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$pic() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.picIndex);
    }

    @Override
    public void realmSet$pic(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.picIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.picIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.picIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.picIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$address() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.addressIndex);
    }

    @Override
    public void realmSet$address(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.addressIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.addressIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.addressIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.addressIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$picture() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.pictureIndex);
    }

    @Override
    public void realmSet$picture(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.pictureIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.pictureIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.pictureIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.pictureIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$areas() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.areasIndex);
    }

    @Override
    public void realmSet$areas(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.areasIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.areasIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.areasIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.areasIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Boolean realmGet$isParent() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.isParentIndex)) {
            return null;
        }
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isParentIndex);
    }

    @Override
    public void realmSet$isParent(Boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.isParentIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setBoolean(columnInfo.isParentIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.isParentIndex);
            return;
        }
        proxyState.getRow$realm().setBoolean(columnInfo.isParentIndex, value);
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

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Group", 11, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("parentId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("pic", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("address", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("picture", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("areas", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("isParent", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("createdAt", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("updatedAt", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("deletedAt", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static GroupColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new GroupColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Group";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Group";
    }

    @SuppressWarnings("cast")
    public static com.example.pro.rumahcemara.models.Group createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.pro.rumahcemara.models.Group obj = realm.createObjectInternal(com.example.pro.rumahcemara.models.Group.class, true, excludeFields);

        final com_example_pro_rumahcemara_models_GroupRealmProxyInterface objProxy = (com_example_pro_rumahcemara_models_GroupRealmProxyInterface) obj;
        if (json.has("id")) {
            if (json.isNull("id")) {
                objProxy.realmSet$id(null);
            } else {
                objProxy.realmSet$id((String) json.getString("id"));
            }
        }
        if (json.has("parentId")) {
            if (json.isNull("parentId")) {
                objProxy.realmSet$parentId(null);
            } else {
                objProxy.realmSet$parentId((String) json.getString("parentId"));
            }
        }
        if (json.has("pic")) {
            if (json.isNull("pic")) {
                objProxy.realmSet$pic(null);
            } else {
                objProxy.realmSet$pic((String) json.getString("pic"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("address")) {
            if (json.isNull("address")) {
                objProxy.realmSet$address(null);
            } else {
                objProxy.realmSet$address((String) json.getString("address"));
            }
        }
        if (json.has("picture")) {
            if (json.isNull("picture")) {
                objProxy.realmSet$picture(null);
            } else {
                objProxy.realmSet$picture((String) json.getString("picture"));
            }
        }
        if (json.has("areas")) {
            if (json.isNull("areas")) {
                objProxy.realmSet$areas(null);
            } else {
                objProxy.realmSet$areas((String) json.getString("areas"));
            }
        }
        if (json.has("isParent")) {
            if (json.isNull("isParent")) {
                objProxy.realmSet$isParent(null);
            } else {
                objProxy.realmSet$isParent((boolean) json.getBoolean("isParent"));
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
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.pro.rumahcemara.models.Group createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.example.pro.rumahcemara.models.Group obj = new com.example.pro.rumahcemara.models.Group();
        final com_example_pro_rumahcemara_models_GroupRealmProxyInterface objProxy = (com_example_pro_rumahcemara_models_GroupRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
            } else if (name.equals("parentId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$parentId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$parentId(null);
                }
            } else if (name.equals("pic")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$pic((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$pic(null);
                }
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("address")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$address((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$address(null);
                }
            } else if (name.equals("picture")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$picture((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$picture(null);
                }
            } else if (name.equals("areas")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$areas((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$areas(null);
                }
            } else if (name.equals("isParent")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$isParent((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$isParent(null);
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
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.example.pro.rumahcemara.models.Group copyOrUpdate(Realm realm, com.example.pro.rumahcemara.models.Group object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.example.pro.rumahcemara.models.Group) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.example.pro.rumahcemara.models.Group copy(Realm realm, com.example.pro.rumahcemara.models.Group newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.pro.rumahcemara.models.Group) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.example.pro.rumahcemara.models.Group realmObject = realm.createObjectInternal(com.example.pro.rumahcemara.models.Group.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_example_pro_rumahcemara_models_GroupRealmProxyInterface realmObjectSource = (com_example_pro_rumahcemara_models_GroupRealmProxyInterface) newObject;
        com_example_pro_rumahcemara_models_GroupRealmProxyInterface realmObjectCopy = (com_example_pro_rumahcemara_models_GroupRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$id(realmObjectSource.realmGet$id());
        realmObjectCopy.realmSet$parentId(realmObjectSource.realmGet$parentId());
        realmObjectCopy.realmSet$pic(realmObjectSource.realmGet$pic());
        realmObjectCopy.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectCopy.realmSet$address(realmObjectSource.realmGet$address());
        realmObjectCopy.realmSet$picture(realmObjectSource.realmGet$picture());
        realmObjectCopy.realmSet$areas(realmObjectSource.realmGet$areas());
        realmObjectCopy.realmSet$isParent(realmObjectSource.realmGet$isParent());
        realmObjectCopy.realmSet$createdAt(realmObjectSource.realmGet$createdAt());
        realmObjectCopy.realmSet$updatedAt(realmObjectSource.realmGet$updatedAt());
        realmObjectCopy.realmSet$deletedAt(realmObjectSource.realmGet$deletedAt());
        return realmObject;
    }

    public static long insert(Realm realm, com.example.pro.rumahcemara.models.Group object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.pro.rumahcemara.models.Group.class);
        long tableNativePtr = table.getNativePtr();
        GroupColumnInfo columnInfo = (GroupColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Group.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$id = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        }
        String realmGet$parentId = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$parentId();
        if (realmGet$parentId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.parentIdIndex, rowIndex, realmGet$parentId, false);
        }
        String realmGet$pic = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$pic();
        if (realmGet$pic != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.picIndex, rowIndex, realmGet$pic, false);
        }
        String realmGet$name = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$address = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$address();
        if (realmGet$address != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
        }
        String realmGet$picture = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$picture();
        if (realmGet$picture != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
        }
        String realmGet$areas = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$areas();
        if (realmGet$areas != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.areasIndex, rowIndex, realmGet$areas, false);
        }
        Boolean realmGet$isParent = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$isParent();
        if (realmGet$isParent != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isParentIndex, rowIndex, realmGet$isParent, false);
        }
        String realmGet$createdAt = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$createdAt();
        if (realmGet$createdAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
        }
        String realmGet$updatedAt = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$updatedAt();
        if (realmGet$updatedAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
        }
        String realmGet$deletedAt = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$deletedAt();
        if (realmGet$deletedAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, realmGet$deletedAt, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.pro.rumahcemara.models.Group.class);
        long tableNativePtr = table.getNativePtr();
        GroupColumnInfo columnInfo = (GroupColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Group.class);
        com.example.pro.rumahcemara.models.Group object = null;
        while (objects.hasNext()) {
            object = (com.example.pro.rumahcemara.models.Group) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$id = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
            }
            String realmGet$parentId = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$parentId();
            if (realmGet$parentId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.parentIdIndex, rowIndex, realmGet$parentId, false);
            }
            String realmGet$pic = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$pic();
            if (realmGet$pic != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.picIndex, rowIndex, realmGet$pic, false);
            }
            String realmGet$name = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            String realmGet$address = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$address();
            if (realmGet$address != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
            }
            String realmGet$picture = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$picture();
            if (realmGet$picture != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
            }
            String realmGet$areas = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$areas();
            if (realmGet$areas != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.areasIndex, rowIndex, realmGet$areas, false);
            }
            Boolean realmGet$isParent = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$isParent();
            if (realmGet$isParent != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isParentIndex, rowIndex, realmGet$isParent, false);
            }
            String realmGet$createdAt = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$createdAt();
            if (realmGet$createdAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
            }
            String realmGet$updatedAt = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$updatedAt();
            if (realmGet$updatedAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
            }
            String realmGet$deletedAt = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$deletedAt();
            if (realmGet$deletedAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, realmGet$deletedAt, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.pro.rumahcemara.models.Group object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.pro.rumahcemara.models.Group.class);
        long tableNativePtr = table.getNativePtr();
        GroupColumnInfo columnInfo = (GroupColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Group.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$id = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
        }
        String realmGet$parentId = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$parentId();
        if (realmGet$parentId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.parentIdIndex, rowIndex, realmGet$parentId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.parentIdIndex, rowIndex, false);
        }
        String realmGet$pic = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$pic();
        if (realmGet$pic != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.picIndex, rowIndex, realmGet$pic, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.picIndex, rowIndex, false);
        }
        String realmGet$name = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$address = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$address();
        if (realmGet$address != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.addressIndex, rowIndex, false);
        }
        String realmGet$picture = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$picture();
        if (realmGet$picture != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.pictureIndex, rowIndex, false);
        }
        String realmGet$areas = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$areas();
        if (realmGet$areas != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.areasIndex, rowIndex, realmGet$areas, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.areasIndex, rowIndex, false);
        }
        Boolean realmGet$isParent = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$isParent();
        if (realmGet$isParent != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isParentIndex, rowIndex, realmGet$isParent, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.isParentIndex, rowIndex, false);
        }
        String realmGet$createdAt = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$createdAt();
        if (realmGet$createdAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.createdAtIndex, rowIndex, false);
        }
        String realmGet$updatedAt = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$updatedAt();
        if (realmGet$updatedAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, false);
        }
        String realmGet$deletedAt = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$deletedAt();
        if (realmGet$deletedAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, realmGet$deletedAt, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.pro.rumahcemara.models.Group.class);
        long tableNativePtr = table.getNativePtr();
        GroupColumnInfo columnInfo = (GroupColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Group.class);
        com.example.pro.rumahcemara.models.Group object = null;
        while (objects.hasNext()) {
            object = (com.example.pro.rumahcemara.models.Group) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$id = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
            }
            String realmGet$parentId = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$parentId();
            if (realmGet$parentId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.parentIdIndex, rowIndex, realmGet$parentId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.parentIdIndex, rowIndex, false);
            }
            String realmGet$pic = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$pic();
            if (realmGet$pic != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.picIndex, rowIndex, realmGet$pic, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.picIndex, rowIndex, false);
            }
            String realmGet$name = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            String realmGet$address = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$address();
            if (realmGet$address != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.addressIndex, rowIndex, false);
            }
            String realmGet$picture = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$picture();
            if (realmGet$picture != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.pictureIndex, rowIndex, false);
            }
            String realmGet$areas = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$areas();
            if (realmGet$areas != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.areasIndex, rowIndex, realmGet$areas, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.areasIndex, rowIndex, false);
            }
            Boolean realmGet$isParent = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$isParent();
            if (realmGet$isParent != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isParentIndex, rowIndex, realmGet$isParent, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.isParentIndex, rowIndex, false);
            }
            String realmGet$createdAt = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$createdAt();
            if (realmGet$createdAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.createdAtIndex, rowIndex, false);
            }
            String realmGet$updatedAt = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$updatedAt();
            if (realmGet$updatedAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, false);
            }
            String realmGet$deletedAt = ((com_example_pro_rumahcemara_models_GroupRealmProxyInterface) object).realmGet$deletedAt();
            if (realmGet$deletedAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, realmGet$deletedAt, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, false);
            }
        }
    }

    public static com.example.pro.rumahcemara.models.Group createDetachedCopy(com.example.pro.rumahcemara.models.Group realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.pro.rumahcemara.models.Group unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.pro.rumahcemara.models.Group();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.pro.rumahcemara.models.Group) cachedObject.object;
            }
            unmanagedObject = (com.example.pro.rumahcemara.models.Group) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_pro_rumahcemara_models_GroupRealmProxyInterface unmanagedCopy = (com_example_pro_rumahcemara_models_GroupRealmProxyInterface) unmanagedObject;
        com_example_pro_rumahcemara_models_GroupRealmProxyInterface realmSource = (com_example_pro_rumahcemara_models_GroupRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$parentId(realmSource.realmGet$parentId());
        unmanagedCopy.realmSet$pic(realmSource.realmGet$pic());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$address(realmSource.realmGet$address());
        unmanagedCopy.realmSet$picture(realmSource.realmGet$picture());
        unmanagedCopy.realmSet$areas(realmSource.realmGet$areas());
        unmanagedCopy.realmSet$isParent(realmSource.realmGet$isParent());
        unmanagedCopy.realmSet$createdAt(realmSource.realmGet$createdAt());
        unmanagedCopy.realmSet$updatedAt(realmSource.realmGet$updatedAt());
        unmanagedCopy.realmSet$deletedAt(realmSource.realmGet$deletedAt());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Group = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{parentId:");
        stringBuilder.append(realmGet$parentId() != null ? realmGet$parentId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{pic:");
        stringBuilder.append(realmGet$pic() != null ? realmGet$pic() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{address:");
        stringBuilder.append(realmGet$address() != null ? realmGet$address() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{picture:");
        stringBuilder.append(realmGet$picture() != null ? realmGet$picture() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{areas:");
        stringBuilder.append(realmGet$areas() != null ? realmGet$areas() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isParent:");
        stringBuilder.append(realmGet$isParent() != null ? realmGet$isParent() : "null");
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
        com_example_pro_rumahcemara_models_GroupRealmProxy aGroup = (com_example_pro_rumahcemara_models_GroupRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aGroup.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aGroup.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aGroup.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
