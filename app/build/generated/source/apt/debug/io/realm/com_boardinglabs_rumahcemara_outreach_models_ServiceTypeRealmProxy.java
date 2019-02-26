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
public class com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxy extends com.boardinglabs.rumahcemara.outreach.models.ServiceType
    implements RealmObjectProxy, com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface {

    static final class ServiceTypeColumnInfo extends ColumnInfo {
        long idIndex;
        long parentIdIndex;
        long picIndex;
        long nameIndex;
        long addressIndex;
        long typeIndex;
        long areasIndex;
        long isParentIndex;
        long createdAtIndex;
        long updatedAtIndex;
        long deletedAtIndex;

        ServiceTypeColumnInfo(OsSchemaInfo schemaInfo) {
            super(11);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("ServiceType");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.parentIdIndex = addColumnDetails("parentId", "parentId", objectSchemaInfo);
            this.picIndex = addColumnDetails("pic", "pic", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", "name", objectSchemaInfo);
            this.addressIndex = addColumnDetails("address", "address", objectSchemaInfo);
            this.typeIndex = addColumnDetails("type", "type", objectSchemaInfo);
            this.areasIndex = addColumnDetails("areas", "areas", objectSchemaInfo);
            this.isParentIndex = addColumnDetails("isParent", "isParent", objectSchemaInfo);
            this.createdAtIndex = addColumnDetails("createdAt", "createdAt", objectSchemaInfo);
            this.updatedAtIndex = addColumnDetails("updatedAt", "updatedAt", objectSchemaInfo);
            this.deletedAtIndex = addColumnDetails("deletedAt", "deletedAt", objectSchemaInfo);
        }

        ServiceTypeColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ServiceTypeColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ServiceTypeColumnInfo src = (ServiceTypeColumnInfo) rawSrc;
            final ServiceTypeColumnInfo dst = (ServiceTypeColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.parentIdIndex = src.parentIdIndex;
            dst.picIndex = src.picIndex;
            dst.nameIndex = src.nameIndex;
            dst.addressIndex = src.addressIndex;
            dst.typeIndex = src.typeIndex;
            dst.areasIndex = src.areasIndex;
            dst.isParentIndex = src.isParentIndex;
            dst.createdAtIndex = src.createdAtIndex;
            dst.updatedAtIndex = src.updatedAtIndex;
            dst.deletedAtIndex = src.deletedAtIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ServiceTypeColumnInfo columnInfo;
    private ProxyState<com.boardinglabs.rumahcemara.outreach.models.ServiceType> proxyState;

    com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ServiceTypeColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.boardinglabs.rumahcemara.outreach.models.ServiceType>(this);
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
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
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
    public String realmGet$type() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.typeIndex);
    }

    @Override
    public void realmSet$type(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.typeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.typeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.typeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.typeIndex, value);
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
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("ServiceType", 11, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("parentId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("pic", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("address", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("type", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
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

    public static ServiceTypeColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ServiceTypeColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "ServiceType";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "ServiceType";
    }

    @SuppressWarnings("cast")
    public static com.boardinglabs.rumahcemara.outreach.models.ServiceType createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.boardinglabs.rumahcemara.outreach.models.ServiceType obj = null;
        if (update) {
            Table table = realm.getTable(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class);
            ServiceTypeColumnInfo columnInfo = (ServiceTypeColumnInfo) realm.getSchema().getColumnInfo(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxy) realm.createObjectInternal(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxy) realm.createObjectInternal(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface objProxy = (com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) obj;
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
        if (json.has("type")) {
            if (json.isNull("type")) {
                objProxy.realmSet$type(null);
            } else {
                objProxy.realmSet$type((String) json.getString("type"));
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
    public static com.boardinglabs.rumahcemara.outreach.models.ServiceType createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.boardinglabs.rumahcemara.outreach.models.ServiceType obj = new com.boardinglabs.rumahcemara.outreach.models.ServiceType();
        final com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface objProxy = (com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) obj;
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
                jsonHasPrimaryKey = true;
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
            } else if (name.equals("type")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$type((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$type(null);
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
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.boardinglabs.rumahcemara.outreach.models.ServiceType copyOrUpdate(Realm realm, com.boardinglabs.rumahcemara.outreach.models.ServiceType object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.boardinglabs.rumahcemara.outreach.models.ServiceType) cachedRealmObject;
        }

        com.boardinglabs.rumahcemara.outreach.models.ServiceType realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class);
            ServiceTypeColumnInfo columnInfo = (ServiceTypeColumnInfo) realm.getSchema().getColumnInfo(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class);
            long pkColumnIndex = columnInfo.idIndex;
            String value = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$id();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.boardinglabs.rumahcemara.outreach.models.ServiceType copy(Realm realm, com.boardinglabs.rumahcemara.outreach.models.ServiceType newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.boardinglabs.rumahcemara.outreach.models.ServiceType) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.boardinglabs.rumahcemara.outreach.models.ServiceType realmObject = realm.createObjectInternal(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class, ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface realmObjectSource = (com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) newObject;
        com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface realmObjectCopy = (com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$parentId(realmObjectSource.realmGet$parentId());
        realmObjectCopy.realmSet$pic(realmObjectSource.realmGet$pic());
        realmObjectCopy.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectCopy.realmSet$address(realmObjectSource.realmGet$address());
        realmObjectCopy.realmSet$type(realmObjectSource.realmGet$type());
        realmObjectCopy.realmSet$areas(realmObjectSource.realmGet$areas());
        realmObjectCopy.realmSet$isParent(realmObjectSource.realmGet$isParent());
        realmObjectCopy.realmSet$createdAt(realmObjectSource.realmGet$createdAt());
        realmObjectCopy.realmSet$updatedAt(realmObjectSource.realmGet$updatedAt());
        realmObjectCopy.realmSet$deletedAt(realmObjectSource.realmGet$deletedAt());
        return realmObject;
    }

    public static long insert(Realm realm, com.boardinglabs.rumahcemara.outreach.models.ServiceType object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class);
        long tableNativePtr = table.getNativePtr();
        ServiceTypeColumnInfo columnInfo = (ServiceTypeColumnInfo) realm.getSchema().getColumnInfo(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$id();
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
        String realmGet$parentId = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$parentId();
        if (realmGet$parentId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.parentIdIndex, rowIndex, realmGet$parentId, false);
        }
        String realmGet$pic = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$pic();
        if (realmGet$pic != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.picIndex, rowIndex, realmGet$pic, false);
        }
        String realmGet$name = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$address = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$address();
        if (realmGet$address != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
        }
        String realmGet$type = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        }
        String realmGet$areas = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$areas();
        if (realmGet$areas != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.areasIndex, rowIndex, realmGet$areas, false);
        }
        Boolean realmGet$isParent = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$isParent();
        if (realmGet$isParent != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isParentIndex, rowIndex, realmGet$isParent, false);
        }
        String realmGet$createdAt = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$createdAt();
        if (realmGet$createdAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
        }
        String realmGet$updatedAt = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$updatedAt();
        if (realmGet$updatedAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
        }
        String realmGet$deletedAt = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$deletedAt();
        if (realmGet$deletedAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, realmGet$deletedAt, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class);
        long tableNativePtr = table.getNativePtr();
        ServiceTypeColumnInfo columnInfo = (ServiceTypeColumnInfo) realm.getSchema().getColumnInfo(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.boardinglabs.rumahcemara.outreach.models.ServiceType object = null;
        while (objects.hasNext()) {
            object = (com.boardinglabs.rumahcemara.outreach.models.ServiceType) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$id();
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
            String realmGet$parentId = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$parentId();
            if (realmGet$parentId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.parentIdIndex, rowIndex, realmGet$parentId, false);
            }
            String realmGet$pic = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$pic();
            if (realmGet$pic != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.picIndex, rowIndex, realmGet$pic, false);
            }
            String realmGet$name = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            String realmGet$address = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$address();
            if (realmGet$address != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
            }
            String realmGet$type = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$type();
            if (realmGet$type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
            }
            String realmGet$areas = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$areas();
            if (realmGet$areas != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.areasIndex, rowIndex, realmGet$areas, false);
            }
            Boolean realmGet$isParent = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$isParent();
            if (realmGet$isParent != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isParentIndex, rowIndex, realmGet$isParent, false);
            }
            String realmGet$createdAt = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$createdAt();
            if (realmGet$createdAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
            }
            String realmGet$updatedAt = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$updatedAt();
            if (realmGet$updatedAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
            }
            String realmGet$deletedAt = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$deletedAt();
            if (realmGet$deletedAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, realmGet$deletedAt, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.boardinglabs.rumahcemara.outreach.models.ServiceType object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class);
        long tableNativePtr = table.getNativePtr();
        ServiceTypeColumnInfo columnInfo = (ServiceTypeColumnInfo) realm.getSchema().getColumnInfo(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$id();
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
        String realmGet$parentId = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$parentId();
        if (realmGet$parentId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.parentIdIndex, rowIndex, realmGet$parentId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.parentIdIndex, rowIndex, false);
        }
        String realmGet$pic = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$pic();
        if (realmGet$pic != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.picIndex, rowIndex, realmGet$pic, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.picIndex, rowIndex, false);
        }
        String realmGet$name = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$address = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$address();
        if (realmGet$address != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.addressIndex, rowIndex, false);
        }
        String realmGet$type = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
        }
        String realmGet$areas = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$areas();
        if (realmGet$areas != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.areasIndex, rowIndex, realmGet$areas, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.areasIndex, rowIndex, false);
        }
        Boolean realmGet$isParent = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$isParent();
        if (realmGet$isParent != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isParentIndex, rowIndex, realmGet$isParent, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.isParentIndex, rowIndex, false);
        }
        String realmGet$createdAt = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$createdAt();
        if (realmGet$createdAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.createdAtIndex, rowIndex, false);
        }
        String realmGet$updatedAt = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$updatedAt();
        if (realmGet$updatedAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, false);
        }
        String realmGet$deletedAt = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$deletedAt();
        if (realmGet$deletedAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, realmGet$deletedAt, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class);
        long tableNativePtr = table.getNativePtr();
        ServiceTypeColumnInfo columnInfo = (ServiceTypeColumnInfo) realm.getSchema().getColumnInfo(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.boardinglabs.rumahcemara.outreach.models.ServiceType object = null;
        while (objects.hasNext()) {
            object = (com.boardinglabs.rumahcemara.outreach.models.ServiceType) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$id();
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
            String realmGet$parentId = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$parentId();
            if (realmGet$parentId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.parentIdIndex, rowIndex, realmGet$parentId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.parentIdIndex, rowIndex, false);
            }
            String realmGet$pic = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$pic();
            if (realmGet$pic != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.picIndex, rowIndex, realmGet$pic, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.picIndex, rowIndex, false);
            }
            String realmGet$name = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            String realmGet$address = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$address();
            if (realmGet$address != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.addressIndex, rowIndex, false);
            }
            String realmGet$type = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$type();
            if (realmGet$type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
            }
            String realmGet$areas = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$areas();
            if (realmGet$areas != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.areasIndex, rowIndex, realmGet$areas, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.areasIndex, rowIndex, false);
            }
            Boolean realmGet$isParent = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$isParent();
            if (realmGet$isParent != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isParentIndex, rowIndex, realmGet$isParent, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.isParentIndex, rowIndex, false);
            }
            String realmGet$createdAt = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$createdAt();
            if (realmGet$createdAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.createdAtIndex, rowIndex, false);
            }
            String realmGet$updatedAt = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$updatedAt();
            if (realmGet$updatedAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, false);
            }
            String realmGet$deletedAt = ((com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) object).realmGet$deletedAt();
            if (realmGet$deletedAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, realmGet$deletedAt, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, false);
            }
        }
    }

    public static com.boardinglabs.rumahcemara.outreach.models.ServiceType createDetachedCopy(com.boardinglabs.rumahcemara.outreach.models.ServiceType realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.boardinglabs.rumahcemara.outreach.models.ServiceType unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.boardinglabs.rumahcemara.outreach.models.ServiceType();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.boardinglabs.rumahcemara.outreach.models.ServiceType) cachedObject.object;
            }
            unmanagedObject = (com.boardinglabs.rumahcemara.outreach.models.ServiceType) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface unmanagedCopy = (com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) unmanagedObject;
        com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface realmSource = (com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$parentId(realmSource.realmGet$parentId());
        unmanagedCopy.realmSet$pic(realmSource.realmGet$pic());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$address(realmSource.realmGet$address());
        unmanagedCopy.realmSet$type(realmSource.realmGet$type());
        unmanagedCopy.realmSet$areas(realmSource.realmGet$areas());
        unmanagedCopy.realmSet$isParent(realmSource.realmGet$isParent());
        unmanagedCopy.realmSet$createdAt(realmSource.realmGet$createdAt());
        unmanagedCopy.realmSet$updatedAt(realmSource.realmGet$updatedAt());
        unmanagedCopy.realmSet$deletedAt(realmSource.realmGet$deletedAt());

        return unmanagedObject;
    }

    static com.boardinglabs.rumahcemara.outreach.models.ServiceType update(Realm realm, com.boardinglabs.rumahcemara.outreach.models.ServiceType realmObject, com.boardinglabs.rumahcemara.outreach.models.ServiceType newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface realmObjectTarget = (com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) realmObject;
        com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface realmObjectSource = (com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$parentId(realmObjectSource.realmGet$parentId());
        realmObjectTarget.realmSet$pic(realmObjectSource.realmGet$pic());
        realmObjectTarget.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectTarget.realmSet$address(realmObjectSource.realmGet$address());
        realmObjectTarget.realmSet$type(realmObjectSource.realmGet$type());
        realmObjectTarget.realmSet$areas(realmObjectSource.realmGet$areas());
        realmObjectTarget.realmSet$isParent(realmObjectSource.realmGet$isParent());
        realmObjectTarget.realmSet$createdAt(realmObjectSource.realmGet$createdAt());
        realmObjectTarget.realmSet$updatedAt(realmObjectSource.realmGet$updatedAt());
        realmObjectTarget.realmSet$deletedAt(realmObjectSource.realmGet$deletedAt());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ServiceType = proxy[");
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
        stringBuilder.append("{type:");
        stringBuilder.append(realmGet$type() != null ? realmGet$type() : "null");
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
        com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxy aServiceType = (com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aServiceType.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aServiceType.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aServiceType.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
