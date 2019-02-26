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
public class com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxy extends com.boardinglabs.rumahcemara.outreach.models.GroupProfile
    implements RealmObjectProxy, com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface {

    static final class GroupProfileColumnInfo extends ColumnInfo {
        long group_idIndex;
        long descriptionIndex;
        long phone_numberIndex;
        long addressIndex;
        long pictureIndex;

        GroupProfileColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("GroupProfile");
            this.group_idIndex = addColumnDetails("group_id", "group_id", objectSchemaInfo);
            this.descriptionIndex = addColumnDetails("description", "description", objectSchemaInfo);
            this.phone_numberIndex = addColumnDetails("phone_number", "phone_number", objectSchemaInfo);
            this.addressIndex = addColumnDetails("address", "address", objectSchemaInfo);
            this.pictureIndex = addColumnDetails("picture", "picture", objectSchemaInfo);
        }

        GroupProfileColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new GroupProfileColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final GroupProfileColumnInfo src = (GroupProfileColumnInfo) rawSrc;
            final GroupProfileColumnInfo dst = (GroupProfileColumnInfo) rawDst;
            dst.group_idIndex = src.group_idIndex;
            dst.descriptionIndex = src.descriptionIndex;
            dst.phone_numberIndex = src.phone_numberIndex;
            dst.addressIndex = src.addressIndex;
            dst.pictureIndex = src.pictureIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private GroupProfileColumnInfo columnInfo;
    private ProxyState<com.boardinglabs.rumahcemara.outreach.models.GroupProfile> proxyState;

    com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (GroupProfileColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.boardinglabs.rumahcemara.outreach.models.GroupProfile>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$group_id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.group_idIndex);
    }

    @Override
    public void realmSet$group_id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.group_idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.group_idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.group_idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.group_idIndex, value);
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
    public String realmGet$phone_number() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.phone_numberIndex);
    }

    @Override
    public void realmSet$phone_number(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.phone_numberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.phone_numberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.phone_numberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.phone_numberIndex, value);
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

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("GroupProfile", 5, 0);
        builder.addPersistedProperty("group_id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("description", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("phone_number", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("address", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("picture", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static GroupProfileColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new GroupProfileColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "GroupProfile";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "GroupProfile";
    }

    @SuppressWarnings("cast")
    public static com.boardinglabs.rumahcemara.outreach.models.GroupProfile createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.boardinglabs.rumahcemara.outreach.models.GroupProfile obj = realm.createObjectInternal(com.boardinglabs.rumahcemara.outreach.models.GroupProfile.class, true, excludeFields);

        final com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface objProxy = (com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface) obj;
        if (json.has("group_id")) {
            if (json.isNull("group_id")) {
                objProxy.realmSet$group_id(null);
            } else {
                objProxy.realmSet$group_id((String) json.getString("group_id"));
            }
        }
        if (json.has("description")) {
            if (json.isNull("description")) {
                objProxy.realmSet$description(null);
            } else {
                objProxy.realmSet$description((String) json.getString("description"));
            }
        }
        if (json.has("phone_number")) {
            if (json.isNull("phone_number")) {
                objProxy.realmSet$phone_number(null);
            } else {
                objProxy.realmSet$phone_number((String) json.getString("phone_number"));
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
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.boardinglabs.rumahcemara.outreach.models.GroupProfile createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.boardinglabs.rumahcemara.outreach.models.GroupProfile obj = new com.boardinglabs.rumahcemara.outreach.models.GroupProfile();
        final com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface objProxy = (com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("group_id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$group_id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$group_id(null);
                }
            } else if (name.equals("description")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$description((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$description(null);
                }
            } else if (name.equals("phone_number")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$phone_number((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$phone_number(null);
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
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.boardinglabs.rumahcemara.outreach.models.GroupProfile copyOrUpdate(Realm realm, com.boardinglabs.rumahcemara.outreach.models.GroupProfile object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.boardinglabs.rumahcemara.outreach.models.GroupProfile) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.boardinglabs.rumahcemara.outreach.models.GroupProfile copy(Realm realm, com.boardinglabs.rumahcemara.outreach.models.GroupProfile newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.boardinglabs.rumahcemara.outreach.models.GroupProfile) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.boardinglabs.rumahcemara.outreach.models.GroupProfile realmObject = realm.createObjectInternal(com.boardinglabs.rumahcemara.outreach.models.GroupProfile.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface realmObjectSource = (com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface) newObject;
        com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface realmObjectCopy = (com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$group_id(realmObjectSource.realmGet$group_id());
        realmObjectCopy.realmSet$description(realmObjectSource.realmGet$description());
        realmObjectCopy.realmSet$phone_number(realmObjectSource.realmGet$phone_number());
        realmObjectCopy.realmSet$address(realmObjectSource.realmGet$address());
        realmObjectCopy.realmSet$picture(realmObjectSource.realmGet$picture());
        return realmObject;
    }

    public static long insert(Realm realm, com.boardinglabs.rumahcemara.outreach.models.GroupProfile object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.boardinglabs.rumahcemara.outreach.models.GroupProfile.class);
        long tableNativePtr = table.getNativePtr();
        GroupProfileColumnInfo columnInfo = (GroupProfileColumnInfo) realm.getSchema().getColumnInfo(com.boardinglabs.rumahcemara.outreach.models.GroupProfile.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$group_id = ((com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface) object).realmGet$group_id();
        if (realmGet$group_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.group_idIndex, rowIndex, realmGet$group_id, false);
        }
        String realmGet$description = ((com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        }
        String realmGet$phone_number = ((com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface) object).realmGet$phone_number();
        if (realmGet$phone_number != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.phone_numberIndex, rowIndex, realmGet$phone_number, false);
        }
        String realmGet$address = ((com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface) object).realmGet$address();
        if (realmGet$address != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
        }
        String realmGet$picture = ((com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface) object).realmGet$picture();
        if (realmGet$picture != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.boardinglabs.rumahcemara.outreach.models.GroupProfile.class);
        long tableNativePtr = table.getNativePtr();
        GroupProfileColumnInfo columnInfo = (GroupProfileColumnInfo) realm.getSchema().getColumnInfo(com.boardinglabs.rumahcemara.outreach.models.GroupProfile.class);
        com.boardinglabs.rumahcemara.outreach.models.GroupProfile object = null;
        while (objects.hasNext()) {
            object = (com.boardinglabs.rumahcemara.outreach.models.GroupProfile) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$group_id = ((com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface) object).realmGet$group_id();
            if (realmGet$group_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.group_idIndex, rowIndex, realmGet$group_id, false);
            }
            String realmGet$description = ((com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
            }
            String realmGet$phone_number = ((com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface) object).realmGet$phone_number();
            if (realmGet$phone_number != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.phone_numberIndex, rowIndex, realmGet$phone_number, false);
            }
            String realmGet$address = ((com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface) object).realmGet$address();
            if (realmGet$address != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
            }
            String realmGet$picture = ((com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface) object).realmGet$picture();
            if (realmGet$picture != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.boardinglabs.rumahcemara.outreach.models.GroupProfile object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.boardinglabs.rumahcemara.outreach.models.GroupProfile.class);
        long tableNativePtr = table.getNativePtr();
        GroupProfileColumnInfo columnInfo = (GroupProfileColumnInfo) realm.getSchema().getColumnInfo(com.boardinglabs.rumahcemara.outreach.models.GroupProfile.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$group_id = ((com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface) object).realmGet$group_id();
        if (realmGet$group_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.group_idIndex, rowIndex, realmGet$group_id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.group_idIndex, rowIndex, false);
        }
        String realmGet$description = ((com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
        }
        String realmGet$phone_number = ((com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface) object).realmGet$phone_number();
        if (realmGet$phone_number != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.phone_numberIndex, rowIndex, realmGet$phone_number, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.phone_numberIndex, rowIndex, false);
        }
        String realmGet$address = ((com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface) object).realmGet$address();
        if (realmGet$address != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.addressIndex, rowIndex, false);
        }
        String realmGet$picture = ((com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface) object).realmGet$picture();
        if (realmGet$picture != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.pictureIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.boardinglabs.rumahcemara.outreach.models.GroupProfile.class);
        long tableNativePtr = table.getNativePtr();
        GroupProfileColumnInfo columnInfo = (GroupProfileColumnInfo) realm.getSchema().getColumnInfo(com.boardinglabs.rumahcemara.outreach.models.GroupProfile.class);
        com.boardinglabs.rumahcemara.outreach.models.GroupProfile object = null;
        while (objects.hasNext()) {
            object = (com.boardinglabs.rumahcemara.outreach.models.GroupProfile) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$group_id = ((com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface) object).realmGet$group_id();
            if (realmGet$group_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.group_idIndex, rowIndex, realmGet$group_id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.group_idIndex, rowIndex, false);
            }
            String realmGet$description = ((com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
            }
            String realmGet$phone_number = ((com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface) object).realmGet$phone_number();
            if (realmGet$phone_number != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.phone_numberIndex, rowIndex, realmGet$phone_number, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.phone_numberIndex, rowIndex, false);
            }
            String realmGet$address = ((com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface) object).realmGet$address();
            if (realmGet$address != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.addressIndex, rowIndex, false);
            }
            String realmGet$picture = ((com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface) object).realmGet$picture();
            if (realmGet$picture != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.pictureIndex, rowIndex, false);
            }
        }
    }

    public static com.boardinglabs.rumahcemara.outreach.models.GroupProfile createDetachedCopy(com.boardinglabs.rumahcemara.outreach.models.GroupProfile realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.boardinglabs.rumahcemara.outreach.models.GroupProfile unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.boardinglabs.rumahcemara.outreach.models.GroupProfile();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.boardinglabs.rumahcemara.outreach.models.GroupProfile) cachedObject.object;
            }
            unmanagedObject = (com.boardinglabs.rumahcemara.outreach.models.GroupProfile) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface unmanagedCopy = (com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface) unmanagedObject;
        com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface realmSource = (com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$group_id(realmSource.realmGet$group_id());
        unmanagedCopy.realmSet$description(realmSource.realmGet$description());
        unmanagedCopy.realmSet$phone_number(realmSource.realmGet$phone_number());
        unmanagedCopy.realmSet$address(realmSource.realmGet$address());
        unmanagedCopy.realmSet$picture(realmSource.realmGet$picture());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("GroupProfile = proxy[");
        stringBuilder.append("{group_id:");
        stringBuilder.append(realmGet$group_id() != null ? realmGet$group_id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{description:");
        stringBuilder.append(realmGet$description() != null ? realmGet$description() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{phone_number:");
        stringBuilder.append(realmGet$phone_number() != null ? realmGet$phone_number() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{address:");
        stringBuilder.append(realmGet$address() != null ? realmGet$address() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{picture:");
        stringBuilder.append(realmGet$picture() != null ? realmGet$picture() : "null");
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
        com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxy aGroupProfile = (com_boardinglabs_rumahcemara_outreach_models_GroupProfileRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aGroupProfile.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aGroupProfile.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aGroupProfile.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
