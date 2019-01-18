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
public class com_example_pro_rumahcemara_models_AppointmentRealmProxy extends com.example.pro.rumahcemara.models.Appointment
    implements RealmObjectProxy, com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface {

    static final class AppointmentColumnInfo extends ColumnInfo {
        long idIndex;
        long group_idIndex;
        long user_idIndex;
        long provider_idIndex;
        long service_type_idIndex;
        long worker_idIndex;
        long start_dateIndex;
        long end_dateIndex;
        long descriptionIndex;
        long attachmentIndex;
        long type_providerIndex;
        long statusIndex;
        long status_reportIndex;
        long groupIndex;
        long userIndex;
        long serviceTypeIndex;
        long workerIndex;
        long providerWorkerIndex;
        long ratingIndex;
        long created_atIndex;
        long updated_atIndex;
        long deleted_atIndex;
        long typeIndex;

        AppointmentColumnInfo(OsSchemaInfo schemaInfo) {
            super(23);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Appointment");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.group_idIndex = addColumnDetails("group_id", "group_id", objectSchemaInfo);
            this.user_idIndex = addColumnDetails("user_id", "user_id", objectSchemaInfo);
            this.provider_idIndex = addColumnDetails("provider_id", "provider_id", objectSchemaInfo);
            this.service_type_idIndex = addColumnDetails("service_type_id", "service_type_id", objectSchemaInfo);
            this.worker_idIndex = addColumnDetails("worker_id", "worker_id", objectSchemaInfo);
            this.start_dateIndex = addColumnDetails("start_date", "start_date", objectSchemaInfo);
            this.end_dateIndex = addColumnDetails("end_date", "end_date", objectSchemaInfo);
            this.descriptionIndex = addColumnDetails("description", "description", objectSchemaInfo);
            this.attachmentIndex = addColumnDetails("attachment", "attachment", objectSchemaInfo);
            this.type_providerIndex = addColumnDetails("type_provider", "type_provider", objectSchemaInfo);
            this.statusIndex = addColumnDetails("status", "status", objectSchemaInfo);
            this.status_reportIndex = addColumnDetails("status_report", "status_report", objectSchemaInfo);
            this.groupIndex = addColumnDetails("group", "group", objectSchemaInfo);
            this.userIndex = addColumnDetails("user", "user", objectSchemaInfo);
            this.serviceTypeIndex = addColumnDetails("serviceType", "serviceType", objectSchemaInfo);
            this.workerIndex = addColumnDetails("worker", "worker", objectSchemaInfo);
            this.providerWorkerIndex = addColumnDetails("providerWorker", "providerWorker", objectSchemaInfo);
            this.ratingIndex = addColumnDetails("rating", "rating", objectSchemaInfo);
            this.created_atIndex = addColumnDetails("created_at", "created_at", objectSchemaInfo);
            this.updated_atIndex = addColumnDetails("updated_at", "updated_at", objectSchemaInfo);
            this.deleted_atIndex = addColumnDetails("deleted_at", "deleted_at", objectSchemaInfo);
            this.typeIndex = addColumnDetails("type", "type", objectSchemaInfo);
        }

        AppointmentColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new AppointmentColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final AppointmentColumnInfo src = (AppointmentColumnInfo) rawSrc;
            final AppointmentColumnInfo dst = (AppointmentColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.group_idIndex = src.group_idIndex;
            dst.user_idIndex = src.user_idIndex;
            dst.provider_idIndex = src.provider_idIndex;
            dst.service_type_idIndex = src.service_type_idIndex;
            dst.worker_idIndex = src.worker_idIndex;
            dst.start_dateIndex = src.start_dateIndex;
            dst.end_dateIndex = src.end_dateIndex;
            dst.descriptionIndex = src.descriptionIndex;
            dst.attachmentIndex = src.attachmentIndex;
            dst.type_providerIndex = src.type_providerIndex;
            dst.statusIndex = src.statusIndex;
            dst.status_reportIndex = src.status_reportIndex;
            dst.groupIndex = src.groupIndex;
            dst.userIndex = src.userIndex;
            dst.serviceTypeIndex = src.serviceTypeIndex;
            dst.workerIndex = src.workerIndex;
            dst.providerWorkerIndex = src.providerWorkerIndex;
            dst.ratingIndex = src.ratingIndex;
            dst.created_atIndex = src.created_atIndex;
            dst.updated_atIndex = src.updated_atIndex;
            dst.deleted_atIndex = src.deleted_atIndex;
            dst.typeIndex = src.typeIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private AppointmentColumnInfo columnInfo;
    private ProxyState<com.example.pro.rumahcemara.models.Appointment> proxyState;

    com_example_pro_rumahcemara_models_AppointmentRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (AppointmentColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.pro.rumahcemara.models.Appointment>(this);
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
    public String realmGet$service_type_id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.service_type_idIndex);
    }

    @Override
    public void realmSet$service_type_id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.service_type_idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.service_type_idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.service_type_idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.service_type_idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$worker_id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.worker_idIndex);
    }

    @Override
    public void realmSet$worker_id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.worker_idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.worker_idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.worker_idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.worker_idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$start_date() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.start_dateIndex);
    }

    @Override
    public void realmSet$start_date(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.start_dateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.start_dateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.start_dateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.start_dateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$end_date() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.end_dateIndex);
    }

    @Override
    public void realmSet$end_date(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.end_dateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.end_dateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.end_dateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.end_dateIndex, value);
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
    public String realmGet$attachment() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.attachmentIndex);
    }

    @Override
    public void realmSet$attachment(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.attachmentIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.attachmentIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.attachmentIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.attachmentIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$type_provider() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.type_providerIndex);
    }

    @Override
    public void realmSet$type_provider(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.type_providerIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.type_providerIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.type_providerIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.type_providerIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$status() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.statusIndex);
    }

    @Override
    public void realmSet$status(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.statusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.statusIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$status_report() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.status_reportIndex);
    }

    @Override
    public void realmSet$status_report(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.status_reportIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.status_reportIndex, value);
    }

    @Override
    public com.example.pro.rumahcemara.models.Group realmGet$group() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.groupIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.pro.rumahcemara.models.Group.class, proxyState.getRow$realm().getLink(columnInfo.groupIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$group(com.example.pro.rumahcemara.models.Group value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("group")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.groupIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.groupIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.groupIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.groupIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public com.example.pro.rumahcemara.models.User realmGet$user() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.userIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.pro.rumahcemara.models.User.class, proxyState.getRow$realm().getLink(columnInfo.userIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$user(com.example.pro.rumahcemara.models.User value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("user")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.userIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.userIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.userIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.userIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public com.example.pro.rumahcemara.models.ServiceType realmGet$serviceType() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.serviceTypeIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.pro.rumahcemara.models.ServiceType.class, proxyState.getRow$realm().getLink(columnInfo.serviceTypeIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$serviceType(com.example.pro.rumahcemara.models.ServiceType value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("serviceType")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.serviceTypeIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.serviceTypeIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.serviceTypeIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.serviceTypeIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public com.example.pro.rumahcemara.models.Worker realmGet$worker() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.workerIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.pro.rumahcemara.models.Worker.class, proxyState.getRow$realm().getLink(columnInfo.workerIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$worker(com.example.pro.rumahcemara.models.Worker value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("worker")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.workerIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.workerIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.workerIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.workerIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public com.example.pro.rumahcemara.models.ProviderWorker realmGet$providerWorker() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.providerWorkerIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.pro.rumahcemara.models.ProviderWorker.class, proxyState.getRow$realm().getLink(columnInfo.providerWorkerIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$providerWorker(com.example.pro.rumahcemara.models.ProviderWorker value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("providerWorker")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.providerWorkerIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.providerWorkerIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.providerWorkerIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.providerWorkerIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public com.example.pro.rumahcemara.models.Rating realmGet$rating() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.ratingIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.pro.rumahcemara.models.Rating.class, proxyState.getRow$realm().getLink(columnInfo.ratingIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$rating(com.example.pro.rumahcemara.models.Rating value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("rating")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.ratingIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.ratingIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.ratingIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.ratingIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
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

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Appointment", 23, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("group_id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("user_id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("provider_id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("service_type_id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("worker_id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("start_date", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("end_date", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("description", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("attachment", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("type_provider", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("status", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("status_report", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedLinkProperty("group", RealmFieldType.OBJECT, "Group");
        builder.addPersistedLinkProperty("user", RealmFieldType.OBJECT, "User");
        builder.addPersistedLinkProperty("serviceType", RealmFieldType.OBJECT, "ServiceType");
        builder.addPersistedLinkProperty("worker", RealmFieldType.OBJECT, "Worker");
        builder.addPersistedLinkProperty("providerWorker", RealmFieldType.OBJECT, "ProviderWorker");
        builder.addPersistedLinkProperty("rating", RealmFieldType.OBJECT, "Rating");
        builder.addPersistedProperty("created_at", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("updated_at", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("deleted_at", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("type", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static AppointmentColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new AppointmentColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Appointment";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Appointment";
    }

    @SuppressWarnings("cast")
    public static com.example.pro.rumahcemara.models.Appointment createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(6);
        if (json.has("group")) {
            excludeFields.add("group");
        }
        if (json.has("user")) {
            excludeFields.add("user");
        }
        if (json.has("serviceType")) {
            excludeFields.add("serviceType");
        }
        if (json.has("worker")) {
            excludeFields.add("worker");
        }
        if (json.has("providerWorker")) {
            excludeFields.add("providerWorker");
        }
        if (json.has("rating")) {
            excludeFields.add("rating");
        }
        com.example.pro.rumahcemara.models.Appointment obj = realm.createObjectInternal(com.example.pro.rumahcemara.models.Appointment.class, true, excludeFields);

        final com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface objProxy = (com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) obj;
        if (json.has("id")) {
            if (json.isNull("id")) {
                objProxy.realmSet$id(null);
            } else {
                objProxy.realmSet$id((String) json.getString("id"));
            }
        }
        if (json.has("group_id")) {
            if (json.isNull("group_id")) {
                objProxy.realmSet$group_id(null);
            } else {
                objProxy.realmSet$group_id((String) json.getString("group_id"));
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
        if (json.has("service_type_id")) {
            if (json.isNull("service_type_id")) {
                objProxy.realmSet$service_type_id(null);
            } else {
                objProxy.realmSet$service_type_id((String) json.getString("service_type_id"));
            }
        }
        if (json.has("worker_id")) {
            if (json.isNull("worker_id")) {
                objProxy.realmSet$worker_id(null);
            } else {
                objProxy.realmSet$worker_id((String) json.getString("worker_id"));
            }
        }
        if (json.has("start_date")) {
            if (json.isNull("start_date")) {
                objProxy.realmSet$start_date(null);
            } else {
                objProxy.realmSet$start_date((String) json.getString("start_date"));
            }
        }
        if (json.has("end_date")) {
            if (json.isNull("end_date")) {
                objProxy.realmSet$end_date(null);
            } else {
                objProxy.realmSet$end_date((String) json.getString("end_date"));
            }
        }
        if (json.has("description")) {
            if (json.isNull("description")) {
                objProxy.realmSet$description(null);
            } else {
                objProxy.realmSet$description((String) json.getString("description"));
            }
        }
        if (json.has("attachment")) {
            if (json.isNull("attachment")) {
                objProxy.realmSet$attachment(null);
            } else {
                objProxy.realmSet$attachment((String) json.getString("attachment"));
            }
        }
        if (json.has("type_provider")) {
            if (json.isNull("type_provider")) {
                objProxy.realmSet$type_provider(null);
            } else {
                objProxy.realmSet$type_provider((String) json.getString("type_provider"));
            }
        }
        if (json.has("status")) {
            if (json.isNull("status")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'status' to null.");
            } else {
                objProxy.realmSet$status((int) json.getInt("status"));
            }
        }
        if (json.has("status_report")) {
            if (json.isNull("status_report")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'status_report' to null.");
            } else {
                objProxy.realmSet$status_report((int) json.getInt("status_report"));
            }
        }
        if (json.has("group")) {
            if (json.isNull("group")) {
                objProxy.realmSet$group(null);
            } else {
                com.example.pro.rumahcemara.models.Group groupObj = com_example_pro_rumahcemara_models_GroupRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("group"), update);
                objProxy.realmSet$group(groupObj);
            }
        }
        if (json.has("user")) {
            if (json.isNull("user")) {
                objProxy.realmSet$user(null);
            } else {
                com.example.pro.rumahcemara.models.User userObj = com_example_pro_rumahcemara_models_UserRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("user"), update);
                objProxy.realmSet$user(userObj);
            }
        }
        if (json.has("serviceType")) {
            if (json.isNull("serviceType")) {
                objProxy.realmSet$serviceType(null);
            } else {
                com.example.pro.rumahcemara.models.ServiceType serviceTypeObj = com_example_pro_rumahcemara_models_ServiceTypeRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("serviceType"), update);
                objProxy.realmSet$serviceType(serviceTypeObj);
            }
        }
        if (json.has("worker")) {
            if (json.isNull("worker")) {
                objProxy.realmSet$worker(null);
            } else {
                com.example.pro.rumahcemara.models.Worker workerObj = com_example_pro_rumahcemara_models_WorkerRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("worker"), update);
                objProxy.realmSet$worker(workerObj);
            }
        }
        if (json.has("providerWorker")) {
            if (json.isNull("providerWorker")) {
                objProxy.realmSet$providerWorker(null);
            } else {
                com.example.pro.rumahcemara.models.ProviderWorker providerWorkerObj = com_example_pro_rumahcemara_models_ProviderWorkerRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("providerWorker"), update);
                objProxy.realmSet$providerWorker(providerWorkerObj);
            }
        }
        if (json.has("rating")) {
            if (json.isNull("rating")) {
                objProxy.realmSet$rating(null);
            } else {
                com.example.pro.rumahcemara.models.Rating ratingObj = com_example_pro_rumahcemara_models_RatingRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("rating"), update);
                objProxy.realmSet$rating(ratingObj);
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
        if (json.has("type")) {
            if (json.isNull("type")) {
                objProxy.realmSet$type(null);
            } else {
                objProxy.realmSet$type((String) json.getString("type"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.pro.rumahcemara.models.Appointment createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.example.pro.rumahcemara.models.Appointment obj = new com.example.pro.rumahcemara.models.Appointment();
        final com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface objProxy = (com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) obj;
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
            } else if (name.equals("group_id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$group_id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$group_id(null);
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
            } else if (name.equals("service_type_id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$service_type_id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$service_type_id(null);
                }
            } else if (name.equals("worker_id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$worker_id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$worker_id(null);
                }
            } else if (name.equals("start_date")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$start_date((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$start_date(null);
                }
            } else if (name.equals("end_date")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$end_date((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$end_date(null);
                }
            } else if (name.equals("description")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$description((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$description(null);
                }
            } else if (name.equals("attachment")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$attachment((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$attachment(null);
                }
            } else if (name.equals("type_provider")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$type_provider((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$type_provider(null);
                }
            } else if (name.equals("status")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$status((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'status' to null.");
                }
            } else if (name.equals("status_report")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$status_report((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'status_report' to null.");
                }
            } else if (name.equals("group")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$group(null);
                } else {
                    com.example.pro.rumahcemara.models.Group groupObj = com_example_pro_rumahcemara_models_GroupRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$group(groupObj);
                }
            } else if (name.equals("user")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$user(null);
                } else {
                    com.example.pro.rumahcemara.models.User userObj = com_example_pro_rumahcemara_models_UserRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$user(userObj);
                }
            } else if (name.equals("serviceType")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$serviceType(null);
                } else {
                    com.example.pro.rumahcemara.models.ServiceType serviceTypeObj = com_example_pro_rumahcemara_models_ServiceTypeRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$serviceType(serviceTypeObj);
                }
            } else if (name.equals("worker")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$worker(null);
                } else {
                    com.example.pro.rumahcemara.models.Worker workerObj = com_example_pro_rumahcemara_models_WorkerRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$worker(workerObj);
                }
            } else if (name.equals("providerWorker")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$providerWorker(null);
                } else {
                    com.example.pro.rumahcemara.models.ProviderWorker providerWorkerObj = com_example_pro_rumahcemara_models_ProviderWorkerRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$providerWorker(providerWorkerObj);
                }
            } else if (name.equals("rating")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$rating(null);
                } else {
                    com.example.pro.rumahcemara.models.Rating ratingObj = com_example_pro_rumahcemara_models_RatingRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$rating(ratingObj);
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
            } else if (name.equals("type")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$type((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$type(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.example.pro.rumahcemara.models.Appointment copyOrUpdate(Realm realm, com.example.pro.rumahcemara.models.Appointment object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.example.pro.rumahcemara.models.Appointment) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.example.pro.rumahcemara.models.Appointment copy(Realm realm, com.example.pro.rumahcemara.models.Appointment newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.pro.rumahcemara.models.Appointment) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.example.pro.rumahcemara.models.Appointment realmObject = realm.createObjectInternal(com.example.pro.rumahcemara.models.Appointment.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface realmObjectSource = (com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) newObject;
        com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface realmObjectCopy = (com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$id(realmObjectSource.realmGet$id());
        realmObjectCopy.realmSet$group_id(realmObjectSource.realmGet$group_id());
        realmObjectCopy.realmSet$user_id(realmObjectSource.realmGet$user_id());
        realmObjectCopy.realmSet$provider_id(realmObjectSource.realmGet$provider_id());
        realmObjectCopy.realmSet$service_type_id(realmObjectSource.realmGet$service_type_id());
        realmObjectCopy.realmSet$worker_id(realmObjectSource.realmGet$worker_id());
        realmObjectCopy.realmSet$start_date(realmObjectSource.realmGet$start_date());
        realmObjectCopy.realmSet$end_date(realmObjectSource.realmGet$end_date());
        realmObjectCopy.realmSet$description(realmObjectSource.realmGet$description());
        realmObjectCopy.realmSet$attachment(realmObjectSource.realmGet$attachment());
        realmObjectCopy.realmSet$type_provider(realmObjectSource.realmGet$type_provider());
        realmObjectCopy.realmSet$status(realmObjectSource.realmGet$status());
        realmObjectCopy.realmSet$status_report(realmObjectSource.realmGet$status_report());

        com.example.pro.rumahcemara.models.Group groupObj = realmObjectSource.realmGet$group();
        if (groupObj == null) {
            realmObjectCopy.realmSet$group(null);
        } else {
            com.example.pro.rumahcemara.models.Group cachegroup = (com.example.pro.rumahcemara.models.Group) cache.get(groupObj);
            if (cachegroup != null) {
                realmObjectCopy.realmSet$group(cachegroup);
            } else {
                realmObjectCopy.realmSet$group(com_example_pro_rumahcemara_models_GroupRealmProxy.copyOrUpdate(realm, groupObj, update, cache));
            }
        }

        com.example.pro.rumahcemara.models.User userObj = realmObjectSource.realmGet$user();
        if (userObj == null) {
            realmObjectCopy.realmSet$user(null);
        } else {
            com.example.pro.rumahcemara.models.User cacheuser = (com.example.pro.rumahcemara.models.User) cache.get(userObj);
            if (cacheuser != null) {
                realmObjectCopy.realmSet$user(cacheuser);
            } else {
                realmObjectCopy.realmSet$user(com_example_pro_rumahcemara_models_UserRealmProxy.copyOrUpdate(realm, userObj, update, cache));
            }
        }

        com.example.pro.rumahcemara.models.ServiceType serviceTypeObj = realmObjectSource.realmGet$serviceType();
        if (serviceTypeObj == null) {
            realmObjectCopy.realmSet$serviceType(null);
        } else {
            com.example.pro.rumahcemara.models.ServiceType cacheserviceType = (com.example.pro.rumahcemara.models.ServiceType) cache.get(serviceTypeObj);
            if (cacheserviceType != null) {
                realmObjectCopy.realmSet$serviceType(cacheserviceType);
            } else {
                realmObjectCopy.realmSet$serviceType(com_example_pro_rumahcemara_models_ServiceTypeRealmProxy.copyOrUpdate(realm, serviceTypeObj, update, cache));
            }
        }

        com.example.pro.rumahcemara.models.Worker workerObj = realmObjectSource.realmGet$worker();
        if (workerObj == null) {
            realmObjectCopy.realmSet$worker(null);
        } else {
            com.example.pro.rumahcemara.models.Worker cacheworker = (com.example.pro.rumahcemara.models.Worker) cache.get(workerObj);
            if (cacheworker != null) {
                realmObjectCopy.realmSet$worker(cacheworker);
            } else {
                realmObjectCopy.realmSet$worker(com_example_pro_rumahcemara_models_WorkerRealmProxy.copyOrUpdate(realm, workerObj, update, cache));
            }
        }

        com.example.pro.rumahcemara.models.ProviderWorker providerWorkerObj = realmObjectSource.realmGet$providerWorker();
        if (providerWorkerObj == null) {
            realmObjectCopy.realmSet$providerWorker(null);
        } else {
            com.example.pro.rumahcemara.models.ProviderWorker cacheproviderWorker = (com.example.pro.rumahcemara.models.ProviderWorker) cache.get(providerWorkerObj);
            if (cacheproviderWorker != null) {
                realmObjectCopy.realmSet$providerWorker(cacheproviderWorker);
            } else {
                realmObjectCopy.realmSet$providerWorker(com_example_pro_rumahcemara_models_ProviderWorkerRealmProxy.copyOrUpdate(realm, providerWorkerObj, update, cache));
            }
        }

        com.example.pro.rumahcemara.models.Rating ratingObj = realmObjectSource.realmGet$rating();
        if (ratingObj == null) {
            realmObjectCopy.realmSet$rating(null);
        } else {
            com.example.pro.rumahcemara.models.Rating cacherating = (com.example.pro.rumahcemara.models.Rating) cache.get(ratingObj);
            if (cacherating != null) {
                realmObjectCopy.realmSet$rating(cacherating);
            } else {
                realmObjectCopy.realmSet$rating(com_example_pro_rumahcemara_models_RatingRealmProxy.copyOrUpdate(realm, ratingObj, update, cache));
            }
        }
        realmObjectCopy.realmSet$created_at(realmObjectSource.realmGet$created_at());
        realmObjectCopy.realmSet$updated_at(realmObjectSource.realmGet$updated_at());
        realmObjectCopy.realmSet$deleted_at(realmObjectSource.realmGet$deleted_at());
        realmObjectCopy.realmSet$type(realmObjectSource.realmGet$type());
        return realmObject;
    }

    public static long insert(Realm realm, com.example.pro.rumahcemara.models.Appointment object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.pro.rumahcemara.models.Appointment.class);
        long tableNativePtr = table.getNativePtr();
        AppointmentColumnInfo columnInfo = (AppointmentColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Appointment.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$id = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        }
        String realmGet$group_id = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$group_id();
        if (realmGet$group_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.group_idIndex, rowIndex, realmGet$group_id, false);
        }
        String realmGet$user_id = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$user_id();
        if (realmGet$user_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.user_idIndex, rowIndex, realmGet$user_id, false);
        }
        String realmGet$provider_id = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$provider_id();
        if (realmGet$provider_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.provider_idIndex, rowIndex, realmGet$provider_id, false);
        }
        String realmGet$service_type_id = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$service_type_id();
        if (realmGet$service_type_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.service_type_idIndex, rowIndex, realmGet$service_type_id, false);
        }
        String realmGet$worker_id = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$worker_id();
        if (realmGet$worker_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.worker_idIndex, rowIndex, realmGet$worker_id, false);
        }
        String realmGet$start_date = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$start_date();
        if (realmGet$start_date != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.start_dateIndex, rowIndex, realmGet$start_date, false);
        }
        String realmGet$end_date = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$end_date();
        if (realmGet$end_date != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.end_dateIndex, rowIndex, realmGet$end_date, false);
        }
        String realmGet$description = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        }
        String realmGet$attachment = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$attachment();
        if (realmGet$attachment != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.attachmentIndex, rowIndex, realmGet$attachment, false);
        }
        String realmGet$type_provider = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$type_provider();
        if (realmGet$type_provider != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.type_providerIndex, rowIndex, realmGet$type_provider, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.statusIndex, rowIndex, ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$status(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.status_reportIndex, rowIndex, ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$status_report(), false);

        com.example.pro.rumahcemara.models.Group groupObj = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$group();
        if (groupObj != null) {
            Long cachegroup = cache.get(groupObj);
            if (cachegroup == null) {
                cachegroup = com_example_pro_rumahcemara_models_GroupRealmProxy.insert(realm, groupObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.groupIndex, rowIndex, cachegroup, false);
        }

        com.example.pro.rumahcemara.models.User userObj = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$user();
        if (userObj != null) {
            Long cacheuser = cache.get(userObj);
            if (cacheuser == null) {
                cacheuser = com_example_pro_rumahcemara_models_UserRealmProxy.insert(realm, userObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.userIndex, rowIndex, cacheuser, false);
        }

        com.example.pro.rumahcemara.models.ServiceType serviceTypeObj = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$serviceType();
        if (serviceTypeObj != null) {
            Long cacheserviceType = cache.get(serviceTypeObj);
            if (cacheserviceType == null) {
                cacheserviceType = com_example_pro_rumahcemara_models_ServiceTypeRealmProxy.insert(realm, serviceTypeObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.serviceTypeIndex, rowIndex, cacheserviceType, false);
        }

        com.example.pro.rumahcemara.models.Worker workerObj = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$worker();
        if (workerObj != null) {
            Long cacheworker = cache.get(workerObj);
            if (cacheworker == null) {
                cacheworker = com_example_pro_rumahcemara_models_WorkerRealmProxy.insert(realm, workerObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.workerIndex, rowIndex, cacheworker, false);
        }

        com.example.pro.rumahcemara.models.ProviderWorker providerWorkerObj = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$providerWorker();
        if (providerWorkerObj != null) {
            Long cacheproviderWorker = cache.get(providerWorkerObj);
            if (cacheproviderWorker == null) {
                cacheproviderWorker = com_example_pro_rumahcemara_models_ProviderWorkerRealmProxy.insert(realm, providerWorkerObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.providerWorkerIndex, rowIndex, cacheproviderWorker, false);
        }

        com.example.pro.rumahcemara.models.Rating ratingObj = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$rating();
        if (ratingObj != null) {
            Long cacherating = cache.get(ratingObj);
            if (cacherating == null) {
                cacherating = com_example_pro_rumahcemara_models_RatingRealmProxy.insert(realm, ratingObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.ratingIndex, rowIndex, cacherating, false);
        }
        String realmGet$created_at = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$created_at();
        if (realmGet$created_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
        }
        String realmGet$updated_at = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$updated_at();
        if (realmGet$updated_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updated_atIndex, rowIndex, realmGet$updated_at, false);
        }
        String realmGet$deleted_at = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$deleted_at();
        if (realmGet$deleted_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.deleted_atIndex, rowIndex, realmGet$deleted_at, false);
        }
        String realmGet$type = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.pro.rumahcemara.models.Appointment.class);
        long tableNativePtr = table.getNativePtr();
        AppointmentColumnInfo columnInfo = (AppointmentColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Appointment.class);
        com.example.pro.rumahcemara.models.Appointment object = null;
        while (objects.hasNext()) {
            object = (com.example.pro.rumahcemara.models.Appointment) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$id = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
            }
            String realmGet$group_id = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$group_id();
            if (realmGet$group_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.group_idIndex, rowIndex, realmGet$group_id, false);
            }
            String realmGet$user_id = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$user_id();
            if (realmGet$user_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.user_idIndex, rowIndex, realmGet$user_id, false);
            }
            String realmGet$provider_id = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$provider_id();
            if (realmGet$provider_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.provider_idIndex, rowIndex, realmGet$provider_id, false);
            }
            String realmGet$service_type_id = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$service_type_id();
            if (realmGet$service_type_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.service_type_idIndex, rowIndex, realmGet$service_type_id, false);
            }
            String realmGet$worker_id = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$worker_id();
            if (realmGet$worker_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.worker_idIndex, rowIndex, realmGet$worker_id, false);
            }
            String realmGet$start_date = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$start_date();
            if (realmGet$start_date != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.start_dateIndex, rowIndex, realmGet$start_date, false);
            }
            String realmGet$end_date = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$end_date();
            if (realmGet$end_date != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.end_dateIndex, rowIndex, realmGet$end_date, false);
            }
            String realmGet$description = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
            }
            String realmGet$attachment = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$attachment();
            if (realmGet$attachment != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.attachmentIndex, rowIndex, realmGet$attachment, false);
            }
            String realmGet$type_provider = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$type_provider();
            if (realmGet$type_provider != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.type_providerIndex, rowIndex, realmGet$type_provider, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.statusIndex, rowIndex, ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$status(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.status_reportIndex, rowIndex, ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$status_report(), false);

            com.example.pro.rumahcemara.models.Group groupObj = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$group();
            if (groupObj != null) {
                Long cachegroup = cache.get(groupObj);
                if (cachegroup == null) {
                    cachegroup = com_example_pro_rumahcemara_models_GroupRealmProxy.insert(realm, groupObj, cache);
                }
                table.setLink(columnInfo.groupIndex, rowIndex, cachegroup, false);
            }

            com.example.pro.rumahcemara.models.User userObj = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$user();
            if (userObj != null) {
                Long cacheuser = cache.get(userObj);
                if (cacheuser == null) {
                    cacheuser = com_example_pro_rumahcemara_models_UserRealmProxy.insert(realm, userObj, cache);
                }
                table.setLink(columnInfo.userIndex, rowIndex, cacheuser, false);
            }

            com.example.pro.rumahcemara.models.ServiceType serviceTypeObj = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$serviceType();
            if (serviceTypeObj != null) {
                Long cacheserviceType = cache.get(serviceTypeObj);
                if (cacheserviceType == null) {
                    cacheserviceType = com_example_pro_rumahcemara_models_ServiceTypeRealmProxy.insert(realm, serviceTypeObj, cache);
                }
                table.setLink(columnInfo.serviceTypeIndex, rowIndex, cacheserviceType, false);
            }

            com.example.pro.rumahcemara.models.Worker workerObj = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$worker();
            if (workerObj != null) {
                Long cacheworker = cache.get(workerObj);
                if (cacheworker == null) {
                    cacheworker = com_example_pro_rumahcemara_models_WorkerRealmProxy.insert(realm, workerObj, cache);
                }
                table.setLink(columnInfo.workerIndex, rowIndex, cacheworker, false);
            }

            com.example.pro.rumahcemara.models.ProviderWorker providerWorkerObj = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$providerWorker();
            if (providerWorkerObj != null) {
                Long cacheproviderWorker = cache.get(providerWorkerObj);
                if (cacheproviderWorker == null) {
                    cacheproviderWorker = com_example_pro_rumahcemara_models_ProviderWorkerRealmProxy.insert(realm, providerWorkerObj, cache);
                }
                table.setLink(columnInfo.providerWorkerIndex, rowIndex, cacheproviderWorker, false);
            }

            com.example.pro.rumahcemara.models.Rating ratingObj = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$rating();
            if (ratingObj != null) {
                Long cacherating = cache.get(ratingObj);
                if (cacherating == null) {
                    cacherating = com_example_pro_rumahcemara_models_RatingRealmProxy.insert(realm, ratingObj, cache);
                }
                table.setLink(columnInfo.ratingIndex, rowIndex, cacherating, false);
            }
            String realmGet$created_at = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$created_at();
            if (realmGet$created_at != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
            }
            String realmGet$updated_at = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$updated_at();
            if (realmGet$updated_at != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.updated_atIndex, rowIndex, realmGet$updated_at, false);
            }
            String realmGet$deleted_at = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$deleted_at();
            if (realmGet$deleted_at != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.deleted_atIndex, rowIndex, realmGet$deleted_at, false);
            }
            String realmGet$type = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$type();
            if (realmGet$type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.pro.rumahcemara.models.Appointment object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.pro.rumahcemara.models.Appointment.class);
        long tableNativePtr = table.getNativePtr();
        AppointmentColumnInfo columnInfo = (AppointmentColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Appointment.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$id = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
        }
        String realmGet$group_id = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$group_id();
        if (realmGet$group_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.group_idIndex, rowIndex, realmGet$group_id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.group_idIndex, rowIndex, false);
        }
        String realmGet$user_id = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$user_id();
        if (realmGet$user_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.user_idIndex, rowIndex, realmGet$user_id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.user_idIndex, rowIndex, false);
        }
        String realmGet$provider_id = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$provider_id();
        if (realmGet$provider_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.provider_idIndex, rowIndex, realmGet$provider_id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.provider_idIndex, rowIndex, false);
        }
        String realmGet$service_type_id = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$service_type_id();
        if (realmGet$service_type_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.service_type_idIndex, rowIndex, realmGet$service_type_id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.service_type_idIndex, rowIndex, false);
        }
        String realmGet$worker_id = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$worker_id();
        if (realmGet$worker_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.worker_idIndex, rowIndex, realmGet$worker_id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.worker_idIndex, rowIndex, false);
        }
        String realmGet$start_date = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$start_date();
        if (realmGet$start_date != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.start_dateIndex, rowIndex, realmGet$start_date, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.start_dateIndex, rowIndex, false);
        }
        String realmGet$end_date = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$end_date();
        if (realmGet$end_date != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.end_dateIndex, rowIndex, realmGet$end_date, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.end_dateIndex, rowIndex, false);
        }
        String realmGet$description = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
        }
        String realmGet$attachment = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$attachment();
        if (realmGet$attachment != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.attachmentIndex, rowIndex, realmGet$attachment, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.attachmentIndex, rowIndex, false);
        }
        String realmGet$type_provider = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$type_provider();
        if (realmGet$type_provider != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.type_providerIndex, rowIndex, realmGet$type_provider, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.type_providerIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.statusIndex, rowIndex, ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$status(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.status_reportIndex, rowIndex, ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$status_report(), false);

        com.example.pro.rumahcemara.models.Group groupObj = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$group();
        if (groupObj != null) {
            Long cachegroup = cache.get(groupObj);
            if (cachegroup == null) {
                cachegroup = com_example_pro_rumahcemara_models_GroupRealmProxy.insertOrUpdate(realm, groupObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.groupIndex, rowIndex, cachegroup, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.groupIndex, rowIndex);
        }

        com.example.pro.rumahcemara.models.User userObj = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$user();
        if (userObj != null) {
            Long cacheuser = cache.get(userObj);
            if (cacheuser == null) {
                cacheuser = com_example_pro_rumahcemara_models_UserRealmProxy.insertOrUpdate(realm, userObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.userIndex, rowIndex, cacheuser, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.userIndex, rowIndex);
        }

        com.example.pro.rumahcemara.models.ServiceType serviceTypeObj = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$serviceType();
        if (serviceTypeObj != null) {
            Long cacheserviceType = cache.get(serviceTypeObj);
            if (cacheserviceType == null) {
                cacheserviceType = com_example_pro_rumahcemara_models_ServiceTypeRealmProxy.insertOrUpdate(realm, serviceTypeObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.serviceTypeIndex, rowIndex, cacheserviceType, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.serviceTypeIndex, rowIndex);
        }

        com.example.pro.rumahcemara.models.Worker workerObj = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$worker();
        if (workerObj != null) {
            Long cacheworker = cache.get(workerObj);
            if (cacheworker == null) {
                cacheworker = com_example_pro_rumahcemara_models_WorkerRealmProxy.insertOrUpdate(realm, workerObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.workerIndex, rowIndex, cacheworker, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.workerIndex, rowIndex);
        }

        com.example.pro.rumahcemara.models.ProviderWorker providerWorkerObj = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$providerWorker();
        if (providerWorkerObj != null) {
            Long cacheproviderWorker = cache.get(providerWorkerObj);
            if (cacheproviderWorker == null) {
                cacheproviderWorker = com_example_pro_rumahcemara_models_ProviderWorkerRealmProxy.insertOrUpdate(realm, providerWorkerObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.providerWorkerIndex, rowIndex, cacheproviderWorker, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.providerWorkerIndex, rowIndex);
        }

        com.example.pro.rumahcemara.models.Rating ratingObj = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$rating();
        if (ratingObj != null) {
            Long cacherating = cache.get(ratingObj);
            if (cacherating == null) {
                cacherating = com_example_pro_rumahcemara_models_RatingRealmProxy.insertOrUpdate(realm, ratingObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.ratingIndex, rowIndex, cacherating, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.ratingIndex, rowIndex);
        }
        String realmGet$created_at = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$created_at();
        if (realmGet$created_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.created_atIndex, rowIndex, false);
        }
        String realmGet$updated_at = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$updated_at();
        if (realmGet$updated_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updated_atIndex, rowIndex, realmGet$updated_at, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.updated_atIndex, rowIndex, false);
        }
        String realmGet$deleted_at = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$deleted_at();
        if (realmGet$deleted_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.deleted_atIndex, rowIndex, realmGet$deleted_at, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.deleted_atIndex, rowIndex, false);
        }
        String realmGet$type = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.pro.rumahcemara.models.Appointment.class);
        long tableNativePtr = table.getNativePtr();
        AppointmentColumnInfo columnInfo = (AppointmentColumnInfo) realm.getSchema().getColumnInfo(com.example.pro.rumahcemara.models.Appointment.class);
        com.example.pro.rumahcemara.models.Appointment object = null;
        while (objects.hasNext()) {
            object = (com.example.pro.rumahcemara.models.Appointment) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$id = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
            }
            String realmGet$group_id = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$group_id();
            if (realmGet$group_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.group_idIndex, rowIndex, realmGet$group_id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.group_idIndex, rowIndex, false);
            }
            String realmGet$user_id = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$user_id();
            if (realmGet$user_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.user_idIndex, rowIndex, realmGet$user_id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.user_idIndex, rowIndex, false);
            }
            String realmGet$provider_id = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$provider_id();
            if (realmGet$provider_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.provider_idIndex, rowIndex, realmGet$provider_id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.provider_idIndex, rowIndex, false);
            }
            String realmGet$service_type_id = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$service_type_id();
            if (realmGet$service_type_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.service_type_idIndex, rowIndex, realmGet$service_type_id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.service_type_idIndex, rowIndex, false);
            }
            String realmGet$worker_id = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$worker_id();
            if (realmGet$worker_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.worker_idIndex, rowIndex, realmGet$worker_id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.worker_idIndex, rowIndex, false);
            }
            String realmGet$start_date = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$start_date();
            if (realmGet$start_date != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.start_dateIndex, rowIndex, realmGet$start_date, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.start_dateIndex, rowIndex, false);
            }
            String realmGet$end_date = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$end_date();
            if (realmGet$end_date != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.end_dateIndex, rowIndex, realmGet$end_date, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.end_dateIndex, rowIndex, false);
            }
            String realmGet$description = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
            }
            String realmGet$attachment = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$attachment();
            if (realmGet$attachment != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.attachmentIndex, rowIndex, realmGet$attachment, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.attachmentIndex, rowIndex, false);
            }
            String realmGet$type_provider = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$type_provider();
            if (realmGet$type_provider != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.type_providerIndex, rowIndex, realmGet$type_provider, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.type_providerIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.statusIndex, rowIndex, ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$status(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.status_reportIndex, rowIndex, ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$status_report(), false);

            com.example.pro.rumahcemara.models.Group groupObj = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$group();
            if (groupObj != null) {
                Long cachegroup = cache.get(groupObj);
                if (cachegroup == null) {
                    cachegroup = com_example_pro_rumahcemara_models_GroupRealmProxy.insertOrUpdate(realm, groupObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.groupIndex, rowIndex, cachegroup, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.groupIndex, rowIndex);
            }

            com.example.pro.rumahcemara.models.User userObj = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$user();
            if (userObj != null) {
                Long cacheuser = cache.get(userObj);
                if (cacheuser == null) {
                    cacheuser = com_example_pro_rumahcemara_models_UserRealmProxy.insertOrUpdate(realm, userObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.userIndex, rowIndex, cacheuser, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.userIndex, rowIndex);
            }

            com.example.pro.rumahcemara.models.ServiceType serviceTypeObj = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$serviceType();
            if (serviceTypeObj != null) {
                Long cacheserviceType = cache.get(serviceTypeObj);
                if (cacheserviceType == null) {
                    cacheserviceType = com_example_pro_rumahcemara_models_ServiceTypeRealmProxy.insertOrUpdate(realm, serviceTypeObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.serviceTypeIndex, rowIndex, cacheserviceType, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.serviceTypeIndex, rowIndex);
            }

            com.example.pro.rumahcemara.models.Worker workerObj = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$worker();
            if (workerObj != null) {
                Long cacheworker = cache.get(workerObj);
                if (cacheworker == null) {
                    cacheworker = com_example_pro_rumahcemara_models_WorkerRealmProxy.insertOrUpdate(realm, workerObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.workerIndex, rowIndex, cacheworker, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.workerIndex, rowIndex);
            }

            com.example.pro.rumahcemara.models.ProviderWorker providerWorkerObj = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$providerWorker();
            if (providerWorkerObj != null) {
                Long cacheproviderWorker = cache.get(providerWorkerObj);
                if (cacheproviderWorker == null) {
                    cacheproviderWorker = com_example_pro_rumahcemara_models_ProviderWorkerRealmProxy.insertOrUpdate(realm, providerWorkerObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.providerWorkerIndex, rowIndex, cacheproviderWorker, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.providerWorkerIndex, rowIndex);
            }

            com.example.pro.rumahcemara.models.Rating ratingObj = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$rating();
            if (ratingObj != null) {
                Long cacherating = cache.get(ratingObj);
                if (cacherating == null) {
                    cacherating = com_example_pro_rumahcemara_models_RatingRealmProxy.insertOrUpdate(realm, ratingObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.ratingIndex, rowIndex, cacherating, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.ratingIndex, rowIndex);
            }
            String realmGet$created_at = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$created_at();
            if (realmGet$created_at != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.created_atIndex, rowIndex, false);
            }
            String realmGet$updated_at = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$updated_at();
            if (realmGet$updated_at != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.updated_atIndex, rowIndex, realmGet$updated_at, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.updated_atIndex, rowIndex, false);
            }
            String realmGet$deleted_at = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$deleted_at();
            if (realmGet$deleted_at != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.deleted_atIndex, rowIndex, realmGet$deleted_at, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.deleted_atIndex, rowIndex, false);
            }
            String realmGet$type = ((com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) object).realmGet$type();
            if (realmGet$type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
            }
        }
    }

    public static com.example.pro.rumahcemara.models.Appointment createDetachedCopy(com.example.pro.rumahcemara.models.Appointment realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.pro.rumahcemara.models.Appointment unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.pro.rumahcemara.models.Appointment();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.pro.rumahcemara.models.Appointment) cachedObject.object;
            }
            unmanagedObject = (com.example.pro.rumahcemara.models.Appointment) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface unmanagedCopy = (com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) unmanagedObject;
        com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface realmSource = (com_example_pro_rumahcemara_models_AppointmentRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$group_id(realmSource.realmGet$group_id());
        unmanagedCopy.realmSet$user_id(realmSource.realmGet$user_id());
        unmanagedCopy.realmSet$provider_id(realmSource.realmGet$provider_id());
        unmanagedCopy.realmSet$service_type_id(realmSource.realmGet$service_type_id());
        unmanagedCopy.realmSet$worker_id(realmSource.realmGet$worker_id());
        unmanagedCopy.realmSet$start_date(realmSource.realmGet$start_date());
        unmanagedCopy.realmSet$end_date(realmSource.realmGet$end_date());
        unmanagedCopy.realmSet$description(realmSource.realmGet$description());
        unmanagedCopy.realmSet$attachment(realmSource.realmGet$attachment());
        unmanagedCopy.realmSet$type_provider(realmSource.realmGet$type_provider());
        unmanagedCopy.realmSet$status(realmSource.realmGet$status());
        unmanagedCopy.realmSet$status_report(realmSource.realmGet$status_report());

        // Deep copy of group
        unmanagedCopy.realmSet$group(com_example_pro_rumahcemara_models_GroupRealmProxy.createDetachedCopy(realmSource.realmGet$group(), currentDepth + 1, maxDepth, cache));

        // Deep copy of user
        unmanagedCopy.realmSet$user(com_example_pro_rumahcemara_models_UserRealmProxy.createDetachedCopy(realmSource.realmGet$user(), currentDepth + 1, maxDepth, cache));

        // Deep copy of serviceType
        unmanagedCopy.realmSet$serviceType(com_example_pro_rumahcemara_models_ServiceTypeRealmProxy.createDetachedCopy(realmSource.realmGet$serviceType(), currentDepth + 1, maxDepth, cache));

        // Deep copy of worker
        unmanagedCopy.realmSet$worker(com_example_pro_rumahcemara_models_WorkerRealmProxy.createDetachedCopy(realmSource.realmGet$worker(), currentDepth + 1, maxDepth, cache));

        // Deep copy of providerWorker
        unmanagedCopy.realmSet$providerWorker(com_example_pro_rumahcemara_models_ProviderWorkerRealmProxy.createDetachedCopy(realmSource.realmGet$providerWorker(), currentDepth + 1, maxDepth, cache));

        // Deep copy of rating
        unmanagedCopy.realmSet$rating(com_example_pro_rumahcemara_models_RatingRealmProxy.createDetachedCopy(realmSource.realmGet$rating(), currentDepth + 1, maxDepth, cache));
        unmanagedCopy.realmSet$created_at(realmSource.realmGet$created_at());
        unmanagedCopy.realmSet$updated_at(realmSource.realmGet$updated_at());
        unmanagedCopy.realmSet$deleted_at(realmSource.realmGet$deleted_at());
        unmanagedCopy.realmSet$type(realmSource.realmGet$type());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Appointment = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{group_id:");
        stringBuilder.append(realmGet$group_id() != null ? realmGet$group_id() : "null");
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
        stringBuilder.append("{service_type_id:");
        stringBuilder.append(realmGet$service_type_id() != null ? realmGet$service_type_id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{worker_id:");
        stringBuilder.append(realmGet$worker_id() != null ? realmGet$worker_id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{start_date:");
        stringBuilder.append(realmGet$start_date() != null ? realmGet$start_date() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{end_date:");
        stringBuilder.append(realmGet$end_date() != null ? realmGet$end_date() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{description:");
        stringBuilder.append(realmGet$description() != null ? realmGet$description() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{attachment:");
        stringBuilder.append(realmGet$attachment() != null ? realmGet$attachment() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{type_provider:");
        stringBuilder.append(realmGet$type_provider() != null ? realmGet$type_provider() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{status:");
        stringBuilder.append(realmGet$status());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{status_report:");
        stringBuilder.append(realmGet$status_report());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{group:");
        stringBuilder.append(realmGet$group() != null ? "Group" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{user:");
        stringBuilder.append(realmGet$user() != null ? "User" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{serviceType:");
        stringBuilder.append(realmGet$serviceType() != null ? "ServiceType" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{worker:");
        stringBuilder.append(realmGet$worker() != null ? "Worker" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{providerWorker:");
        stringBuilder.append(realmGet$providerWorker() != null ? "ProviderWorker" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{rating:");
        stringBuilder.append(realmGet$rating() != null ? "Rating" : "null");
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
        stringBuilder.append(",");
        stringBuilder.append("{type:");
        stringBuilder.append(realmGet$type() != null ? realmGet$type() : "null");
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
        com_example_pro_rumahcemara_models_AppointmentRealmProxy aAppointment = (com_example_pro_rumahcemara_models_AppointmentRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aAppointment.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aAppointment.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aAppointment.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
