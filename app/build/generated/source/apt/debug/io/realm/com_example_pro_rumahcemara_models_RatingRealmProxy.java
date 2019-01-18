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
public class com_example_pro_rumahcemara_models_RatingRealmProxy extends com.example.pro.rumahcemara.models.Rating
    implements RealmObjectProxy, com_example_pro_rumahcemara_models_RatingRealmProxyInterface {

    static final class RatingColumnInfo extends ColumnInfo {
        long idIndex;
        long service_transaction_idIndex;
        long user_idIndex;
        long provider_idIndex;
        long typeIndex;
        long ratingIndex;
        long descriptionIndex;
        long created_atIndex;
        long updated_atIndex;
        long deleted_atIndex;

        RatingColumnInfo(OsSchemaInfo schemaInfo) {
            super(10);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Rating");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.service_transaction_idIndex = addColumnDetails("service_transaction_id", "service_transaction_id", objectSchemaInfo);
            this.user_idIndex = addColumnDetails("user_id", "user_id", objectSchemaInfo);
            this.provider_idIndex = addColumnDetails("provider_id", "provider_id", objectSchemaInfo);
            this.typeIndex = addColumnDetails("type", "type", objectSchemaInfo);
            this.ratingIndex = addColumnDetails("rating", "rating", objectSchemaInfo);
            this.descriptionIndex = addColumnDetails("description", "description", objectSchemaInfo);
            this.created_atIndex = addColumnDetails("created_at", "created_at", objectSchemaInfo);
            this.updated_atIndex = addColumnDetails("updated_at", "updated_at", objectSchemaInfo);
            this.deleted_atIndex = addColumnDetails("deleted_at", "deleted_at", objectSchemaInfo);
        }

        RatingColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RatingColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RatingColumnInfo src = (RatingColumnInfo) rawSrc;
            final RatingColumnInfo dst = (RatingColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.service_transaction_idIndex = src.service_transaction_idIndex;
            dst.user_idIndex = src.user_idIndex;
            dst.provider_idIndex = src.provider_idIndex;
            dst.typeIndex = src.typeIndex;
            dst.ratingIndex = src.ratingIndex;
            dst.descriptionIndex = src.descriptionIndex;
            dst.created_atIndex = src.created_atIndex;
            dst.updated_atIndex = src.updated_atIndex;
            dst.deleted_atIndex = src.deleted_atIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private RatingColumnInfo columnInfo;
    private ProxyState<com.example.pro.rumahcemara.models.Rating> proxyState;

    com_example_pro_rumahcemara_models_RatingRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RatingColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.pro.rumahcemara.models.Rating>(this);
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
    public String realmGet$service_transaction_id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.service_transaction_idIndex);
    }

    @Override
    public void realmSet$service_transaction_id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.service_transaction_idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.service_transaction_idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.service_transaction_idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.service_transaction_idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$user_id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.user_idIndex);
    }

    @Override
    public void realmSet$user_id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.user_idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.user_idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.user_idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.user_idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$provider_id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.provider_idIndex);
    }

    @Override
    public void realmSet$provider_id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.provider_idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.provider_idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.provider_idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.provider_idIndex, value);
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
    public String realmGet$rating() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.ratingIndex);
    }

    @Override
    public void realmSet$rating(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.ratingIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.ratingIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.ratingIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.ratingIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$description() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.descriptionIndex);
    }

    @Override
    public void realmSet$description(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.descriptionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.descriptionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.descriptionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.descriptionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$created_at() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.created_atIndex);
    }

    @Override
    public void realmSet$created_at(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.created_atIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.created_atIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.created_atIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.created_atIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$updated_at() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.updated_atIndex);
    }

    @Override
    public void realmSet$updated_at(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.updated_atIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.updated_atIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.updated_atIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.updated_atIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$deleted_at() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.deleted_atIndex);
    }

    @Override
    public void realmSet$deleted_at(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.deleted_atIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.deleted_atIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.deleted_atIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.deleted_atIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Rating", 10, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("service_transaction_id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("user_id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("provider_id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("type", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("rating", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("description", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("created_at", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("updated_at", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("deleted_at", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RatingColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RatingColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Rating";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Rating";
    }

    @SuppressWarnings("cast")
    public static com.example.pro.rumahcemara.models.Rating createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.pro.rumahcemara.models.Rating obj = null;
        if (update) {
            Table table = realm.getTable(com.example.pro.rumahcemara.models.Rating.class);
            RatingColumnInfo columnInfo = (RatingColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Rating.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Rating.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_example_pro_rumahcemara_models_RatingRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_example_pro_rumahcemara_models_RatingRealmProxy) realm.createObjectInternal(com.example.pro.rumahcemara.models.Rating.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_example_pro_rumahcemara_models_RatingRealmProxy) realm.createObjectInternal(com.example.pro.rumahcemara.models.Rating.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_example_pro_rumahcemara_models_RatingRealmProxyInterface objProxy = (com_example_pro_rumahcemara_models_RatingRealmProxyInterface) obj;
        if (json.has("service_transaction_id")) {
            if (json.isNull("service_transaction_id")) {
                objProxy.realmSet$service_transaction_id(null);
            } else {
                objProxy.realmSet$service_transaction_id((String) json.getString("service_transaction_id"));
            }
        }
        if (json.has("user_id")) {
            if (json.isNull("user_id")) {
                objProxy.realmSet$user_id(null);
            } else {
                objProxy.realmSet$user_id((String) json.getString("user_id"));
            }
        }
        if (json.has("provider_id")) {
            if (json.isNull("provider_id")) {
                objProxy.realmSet$provider_id(null);
            } else {
                objProxy.realmSet$provider_id((String) json.getString("provider_id"));
            }
        }
        if (json.has("type")) {
            if (json.isNull("type")) {
                objProxy.realmSet$type(null);
            } else {
                objProxy.realmSet$type((String) json.getString("type"));
            }
        }
        if (json.has("rating")) {
            if (json.isNull("rating")) {
                objProxy.realmSet$rating(null);
            } else {
                objProxy.realmSet$rating((String) json.getString("rating"));
            }
        }
        if (json.has("description")) {
            if (json.isNull("description")) {
                objProxy.realmSet$description(null);
            } else {
                objProxy.realmSet$description((String) json.getString("description"));
            }
        }
        if (json.has("created_at")) {
            if (json.isNull("created_at")) {
                objProxy.realmSet$created_at(null);
            } else {
                objProxy.realmSet$created_at((String) json.getString("created_at"));
            }
        }
        if (json.has("updated_at")) {
            if (json.isNull("updated_at")) {
                objProxy.realmSet$updated_at(null);
            } else {
                objProxy.realmSet$updated_at((String) json.getString("updated_at"));
            }
        }
        if (json.has("deleted_at")) {
            if (json.isNull("deleted_at")) {
                objProxy.realmSet$deleted_at(null);
            } else {
                objProxy.realmSet$deleted_at((String) json.getString("deleted_at"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.pro.rumahcemara.models.Rating createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.example.pro.rumahcemara.models.Rating obj = new com.example.pro.rumahcemara.models.Rating();
        final com_example_pro_rumahcemara_models_RatingRealmProxyInterface objProxy = (com_example_pro_rumahcemara_models_RatingRealmProxyInterface) obj;
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
            } else if (name.equals("service_transaction_id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$service_transaction_id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$service_transaction_id(null);
                }
            } else if (name.equals("user_id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$user_id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$user_id(null);
                }
            } else if (name.equals("provider_id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$provider_id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$provider_id(null);
                }
            } else if (name.equals("type")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$type((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$type(null);
                }
            } else if (name.equals("rating")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$rating((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$rating(null);
                }
            } else if (name.equals("description")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$description((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$description(null);
                }
            } else if (name.equals("created_at")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$created_at((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$created_at(null);
                }
            } else if (name.equals("updated_at")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$updated_at((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$updated_at(null);
                }
            } else if (name.equals("deleted_at")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$deleted_at((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$deleted_at(null);
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

    public static com.example.pro.rumahcemara.models.Rating copyOrUpdate(Realm realm, com.example.pro.rumahcemara.models.Rating object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.example.pro.rumahcemara.models.Rating) cachedRealmObject;
        }

        com.example.pro.rumahcemara.models.Rating realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.example.pro.rumahcemara.models.Rating.class);
            RatingColumnInfo columnInfo = (RatingColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Rating.class);
            long pkColumnIndex = columnInfo.idIndex;
            String value = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$id();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Rating.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_example_pro_rumahcemara_models_RatingRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.example.pro.rumahcemara.models.Rating copy(Realm realm, com.example.pro.rumahcemara.models.Rating newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.pro.rumahcemara.models.Rating) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.example.pro.rumahcemara.models.Rating realmObject = realm.createObjectInternal(com.example.pro.rumahcemara.models.Rating.class, ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_example_pro_rumahcemara_models_RatingRealmProxyInterface realmObjectSource = (com_example_pro_rumahcemara_models_RatingRealmProxyInterface) newObject;
        com_example_pro_rumahcemara_models_RatingRealmProxyInterface realmObjectCopy = (com_example_pro_rumahcemara_models_RatingRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$service_transaction_id(realmObjectSource.realmGet$service_transaction_id());
        realmObjectCopy.realmSet$user_id(realmObjectSource.realmGet$user_id());
        realmObjectCopy.realmSet$provider_id(realmObjectSource.realmGet$provider_id());
        realmObjectCopy.realmSet$type(realmObjectSource.realmGet$type());
        realmObjectCopy.realmSet$rating(realmObjectSource.realmGet$rating());
        realmObjectCopy.realmSet$description(realmObjectSource.realmGet$description());
        realmObjectCopy.realmSet$created_at(realmObjectSource.realmGet$created_at());
        realmObjectCopy.realmSet$updated_at(realmObjectSource.realmGet$updated_at());
        realmObjectCopy.realmSet$deleted_at(realmObjectSource.realmGet$deleted_at());
        return realmObject;
    }

    public static long insert(Realm realm, com.example.pro.rumahcemara.models.Rating object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.pro.rumahcemara.models.Rating.class);
        long tableNativePtr = table.getNativePtr();
        RatingColumnInfo columnInfo = (RatingColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Rating.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$id();
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
        String realmGet$service_transaction_id = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$service_transaction_id();
        if (realmGet$service_transaction_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.service_transaction_idIndex, rowIndex, realmGet$service_transaction_id, false);
        }
        String realmGet$user_id = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$user_id();
        if (realmGet$user_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.user_idIndex, rowIndex, realmGet$user_id, false);
        }
        String realmGet$provider_id = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$provider_id();
        if (realmGet$provider_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.provider_idIndex, rowIndex, realmGet$provider_id, false);
        }
        String realmGet$type = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        }
        String realmGet$rating = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$rating();
        if (realmGet$rating != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ratingIndex, rowIndex, realmGet$rating, false);
        }
        String realmGet$description = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        }
        String realmGet$created_at = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$created_at();
        if (realmGet$created_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
        }
        String realmGet$updated_at = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$updated_at();
        if (realmGet$updated_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updated_atIndex, rowIndex, realmGet$updated_at, false);
        }
        String realmGet$deleted_at = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$deleted_at();
        if (realmGet$deleted_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.deleted_atIndex, rowIndex, realmGet$deleted_at, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.pro.rumahcemara.models.Rating.class);
        long tableNativePtr = table.getNativePtr();
        RatingColumnInfo columnInfo = (RatingColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Rating.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.example.pro.rumahcemara.models.Rating object = null;
        while (objects.hasNext()) {
            object = (com.example.pro.rumahcemara.models.Rating) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$id();
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
            String realmGet$service_transaction_id = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$service_transaction_id();
            if (realmGet$service_transaction_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.service_transaction_idIndex, rowIndex, realmGet$service_transaction_id, false);
            }
            String realmGet$user_id = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$user_id();
            if (realmGet$user_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.user_idIndex, rowIndex, realmGet$user_id, false);
            }
            String realmGet$provider_id = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$provider_id();
            if (realmGet$provider_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.provider_idIndex, rowIndex, realmGet$provider_id, false);
            }
            String realmGet$type = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$type();
            if (realmGet$type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
            }
            String realmGet$rating = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$rating();
            if (realmGet$rating != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ratingIndex, rowIndex, realmGet$rating, false);
            }
            String realmGet$description = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
            }
            String realmGet$created_at = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$created_at();
            if (realmGet$created_at != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
            }
            String realmGet$updated_at = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$updated_at();
            if (realmGet$updated_at != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.updated_atIndex, rowIndex, realmGet$updated_at, false);
            }
            String realmGet$deleted_at = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$deleted_at();
            if (realmGet$deleted_at != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.deleted_atIndex, rowIndex, realmGet$deleted_at, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.pro.rumahcemara.models.Rating object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.pro.rumahcemara.models.Rating.class);
        long tableNativePtr = table.getNativePtr();
        RatingColumnInfo columnInfo = (RatingColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Rating.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$id();
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
        String realmGet$service_transaction_id = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$service_transaction_id();
        if (realmGet$service_transaction_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.service_transaction_idIndex, rowIndex, realmGet$service_transaction_id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.service_transaction_idIndex, rowIndex, false);
        }
        String realmGet$user_id = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$user_id();
        if (realmGet$user_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.user_idIndex, rowIndex, realmGet$user_id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.user_idIndex, rowIndex, false);
        }
        String realmGet$provider_id = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$provider_id();
        if (realmGet$provider_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.provider_idIndex, rowIndex, realmGet$provider_id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.provider_idIndex, rowIndex, false);
        }
        String realmGet$type = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
        }
        String realmGet$rating = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$rating();
        if (realmGet$rating != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ratingIndex, rowIndex, realmGet$rating, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.ratingIndex, rowIndex, false);
        }
        String realmGet$description = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
        }
        String realmGet$created_at = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$created_at();
        if (realmGet$created_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.created_atIndex, rowIndex, false);
        }
        String realmGet$updated_at = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$updated_at();
        if (realmGet$updated_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updated_atIndex, rowIndex, realmGet$updated_at, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.updated_atIndex, rowIndex, false);
        }
        String realmGet$deleted_at = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$deleted_at();
        if (realmGet$deleted_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.deleted_atIndex, rowIndex, realmGet$deleted_at, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.deleted_atIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.pro.rumahcemara.models.Rating.class);
        long tableNativePtr = table.getNativePtr();
        RatingColumnInfo columnInfo = (RatingColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Rating.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.example.pro.rumahcemara.models.Rating object = null;
        while (objects.hasNext()) {
            object = (com.example.pro.rumahcemara.models.Rating) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$id();
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
            String realmGet$service_transaction_id = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$service_transaction_id();
            if (realmGet$service_transaction_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.service_transaction_idIndex, rowIndex, realmGet$service_transaction_id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.service_transaction_idIndex, rowIndex, false);
            }
            String realmGet$user_id = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$user_id();
            if (realmGet$user_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.user_idIndex, rowIndex, realmGet$user_id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.user_idIndex, rowIndex, false);
            }
            String realmGet$provider_id = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$provider_id();
            if (realmGet$provider_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.provider_idIndex, rowIndex, realmGet$provider_id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.provider_idIndex, rowIndex, false);
            }
            String realmGet$type = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$type();
            if (realmGet$type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
            }
            String realmGet$rating = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$rating();
            if (realmGet$rating != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ratingIndex, rowIndex, realmGet$rating, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.ratingIndex, rowIndex, false);
            }
            String realmGet$description = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
            }
            String realmGet$created_at = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$created_at();
            if (realmGet$created_at != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.created_atIndex, rowIndex, false);
            }
            String realmGet$updated_at = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$updated_at();
            if (realmGet$updated_at != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.updated_atIndex, rowIndex, realmGet$updated_at, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.updated_atIndex, rowIndex, false);
            }
            String realmGet$deleted_at = ((com_example_pro_rumahcemara_models_RatingRealmProxyInterface) object).realmGet$deleted_at();
            if (realmGet$deleted_at != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.deleted_atIndex, rowIndex, realmGet$deleted_at, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.deleted_atIndex, rowIndex, false);
            }
        }
    }

    public static com.example.pro.rumahcemara.models.Rating createDetachedCopy(com.example.pro.rumahcemara.models.Rating realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.pro.rumahcemara.models.Rating unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.pro.rumahcemara.models.Rating();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.pro.rumahcemara.models.Rating) cachedObject.object;
            }
            unmanagedObject = (com.example.pro.rumahcemara.models.Rating) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_pro_rumahcemara_models_RatingRealmProxyInterface unmanagedCopy = (com_example_pro_rumahcemara_models_RatingRealmProxyInterface) unmanagedObject;
        com_example_pro_rumahcemara_models_RatingRealmProxyInterface realmSource = (com_example_pro_rumahcemara_models_RatingRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$service_transaction_id(realmSource.realmGet$service_transaction_id());
        unmanagedCopy.realmSet$user_id(realmSource.realmGet$user_id());
        unmanagedCopy.realmSet$provider_id(realmSource.realmGet$provider_id());
        unmanagedCopy.realmSet$type(realmSource.realmGet$type());
        unmanagedCopy.realmSet$rating(realmSource.realmGet$rating());
        unmanagedCopy.realmSet$description(realmSource.realmGet$description());
        unmanagedCopy.realmSet$created_at(realmSource.realmGet$created_at());
        unmanagedCopy.realmSet$updated_at(realmSource.realmGet$updated_at());
        unmanagedCopy.realmSet$deleted_at(realmSource.realmGet$deleted_at());

        return unmanagedObject;
    }

    static com.example.pro.rumahcemara.models.Rating update(Realm realm, com.example.pro.rumahcemara.models.Rating realmObject, com.example.pro.rumahcemara.models.Rating newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_example_pro_rumahcemara_models_RatingRealmProxyInterface realmObjectTarget = (com_example_pro_rumahcemara_models_RatingRealmProxyInterface) realmObject;
        com_example_pro_rumahcemara_models_RatingRealmProxyInterface realmObjectSource = (com_example_pro_rumahcemara_models_RatingRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$service_transaction_id(realmObjectSource.realmGet$service_transaction_id());
        realmObjectTarget.realmSet$user_id(realmObjectSource.realmGet$user_id());
        realmObjectTarget.realmSet$provider_id(realmObjectSource.realmGet$provider_id());
        realmObjectTarget.realmSet$type(realmObjectSource.realmGet$type());
        realmObjectTarget.realmSet$rating(realmObjectSource.realmGet$rating());
        realmObjectTarget.realmSet$description(realmObjectSource.realmGet$description());
        realmObjectTarget.realmSet$created_at(realmObjectSource.realmGet$created_at());
        realmObjectTarget.realmSet$updated_at(realmObjectSource.realmGet$updated_at());
        realmObjectTarget.realmSet$deleted_at(realmObjectSource.realmGet$deleted_at());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Rating = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{service_transaction_id:");
        stringBuilder.append(realmGet$service_transaction_id() != null ? realmGet$service_transaction_id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{user_id:");
        stringBuilder.append(realmGet$user_id() != null ? realmGet$user_id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{provider_id:");
        stringBuilder.append(realmGet$provider_id() != null ? realmGet$provider_id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{type:");
        stringBuilder.append(realmGet$type() != null ? realmGet$type() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{rating:");
        stringBuilder.append(realmGet$rating() != null ? realmGet$rating() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{description:");
        stringBuilder.append(realmGet$description() != null ? realmGet$description() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{created_at:");
        stringBuilder.append(realmGet$created_at() != null ? realmGet$created_at() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{updated_at:");
        stringBuilder.append(realmGet$updated_at() != null ? realmGet$updated_at() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{deleted_at:");
        stringBuilder.append(realmGet$deleted_at() != null ? realmGet$deleted_at() : "null");
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
        com_example_pro_rumahcemara_models_RatingRealmProxy aRating = (com_example_pro_rumahcemara_models_RatingRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aRating.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRating.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aRating.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
