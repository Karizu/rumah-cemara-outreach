package io.realm;


import android.util.JsonReader;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class RumahCemaraRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>(12);
        modelClasses.add(com.boardinglabs.rumahcemara.outreach.models.Profile.class);
        modelClasses.add(com.boardinglabs.rumahcemara.outreach.models.Group.class);
        modelClasses.add(com.boardinglabs.rumahcemara.outreach.models.Appointment.class);
        modelClasses.add(com.boardinglabs.rumahcemara.outreach.models.Register.class);
        modelClasses.add(com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile.class);
        modelClasses.add(com.boardinglabs.rumahcemara.outreach.models.User.class);
        modelClasses.add(com.boardinglabs.rumahcemara.outreach.models.ProviderWorker.class);
        modelClasses.add(com.boardinglabs.rumahcemara.outreach.models.Worker.class);
        modelClasses.add(com.boardinglabs.rumahcemara.outreach.models.Total7Day.class);
        modelClasses.add(com.boardinglabs.rumahcemara.outreach.models.Rating.class);
        modelClasses.add(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class);
        modelClasses.add(com.boardinglabs.rumahcemara.outreach.models.Password.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<Class<? extends RealmModel>, OsObjectSchemaInfo>(12);
        infoMap.put(com.boardinglabs.rumahcemara.outreach.models.Profile.class, io.realm.com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.boardinglabs.rumahcemara.outreach.models.Group.class, io.realm.com_boardinglabs_rumahcemara_outreach_models_GroupRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.boardinglabs.rumahcemara.outreach.models.Appointment.class, io.realm.com_boardinglabs_rumahcemara_outreach_models_AppointmentRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.boardinglabs.rumahcemara.outreach.models.Register.class, io.realm.com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile.class, io.realm.com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.boardinglabs.rumahcemara.outreach.models.User.class, io.realm.com_boardinglabs_rumahcemara_outreach_models_UserRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.boardinglabs.rumahcemara.outreach.models.ProviderWorker.class, io.realm.com_boardinglabs_rumahcemara_outreach_models_ProviderWorkerRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.boardinglabs.rumahcemara.outreach.models.Worker.class, io.realm.com_boardinglabs_rumahcemara_outreach_models_WorkerRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.boardinglabs.rumahcemara.outreach.models.Total7Day.class, io.realm.com_boardinglabs_rumahcemara_outreach_models_Total7DayRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.boardinglabs.rumahcemara.outreach.models.Rating.class, io.realm.com_boardinglabs_rumahcemara_outreach_models_RatingRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class, io.realm.com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.boardinglabs.rumahcemara.outreach.models.Password.class, io.realm.com_boardinglabs_rumahcemara_outreach_models_PasswordRealmProxy.getExpectedObjectSchemaInfo());
        return infoMap;
    }

    @Override
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> clazz, OsSchemaInfo schemaInfo) {
        checkClass(clazz);

        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Profile.class)) {
            return io.realm.com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Group.class)) {
            return io.realm.com_boardinglabs_rumahcemara_outreach_models_GroupRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Appointment.class)) {
            return io.realm.com_boardinglabs_rumahcemara_outreach_models_AppointmentRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Register.class)) {
            return io.realm.com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile.class)) {
            return io.realm.com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.User.class)) {
            return io.realm.com_boardinglabs_rumahcemara_outreach_models_UserRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.ProviderWorker.class)) {
            return io.realm.com_boardinglabs_rumahcemara_outreach_models_ProviderWorkerRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Worker.class)) {
            return io.realm.com_boardinglabs_rumahcemara_outreach_models_WorkerRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Total7Day.class)) {
            return io.realm.com_boardinglabs_rumahcemara_outreach_models_Total7DayRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Rating.class)) {
            return io.realm.com_boardinglabs_rumahcemara_outreach_models_RatingRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class)) {
            return io.realm.com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Password.class)) {
            return io.realm.com_boardinglabs_rumahcemara_outreach_models_PasswordRealmProxy.createColumnInfo(schemaInfo);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getSimpleClassNameImpl(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Profile.class)) {
            return "Profile";
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Group.class)) {
            return "Group";
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Appointment.class)) {
            return "Appointment";
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Register.class)) {
            return "Register";
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile.class)) {
            return "GeneralDataProfile";
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.User.class)) {
            return "User";
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.ProviderWorker.class)) {
            return "ProviderWorker";
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Worker.class)) {
            return "Worker";
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Total7Day.class)) {
            return "Total7Day";
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Rating.class)) {
            return "Rating";
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class)) {
            return "ServiceType";
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Password.class)) {
            return "Password";
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Profile.class)) {
                return clazz.cast(new io.realm.com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxy());
            }
            if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Group.class)) {
                return clazz.cast(new io.realm.com_boardinglabs_rumahcemara_outreach_models_GroupRealmProxy());
            }
            if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Appointment.class)) {
                return clazz.cast(new io.realm.com_boardinglabs_rumahcemara_outreach_models_AppointmentRealmProxy());
            }
            if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Register.class)) {
                return clazz.cast(new io.realm.com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxy());
            }
            if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile.class)) {
                return clazz.cast(new io.realm.com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxy());
            }
            if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.User.class)) {
                return clazz.cast(new io.realm.com_boardinglabs_rumahcemara_outreach_models_UserRealmProxy());
            }
            if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.ProviderWorker.class)) {
                return clazz.cast(new io.realm.com_boardinglabs_rumahcemara_outreach_models_ProviderWorkerRealmProxy());
            }
            if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Worker.class)) {
                return clazz.cast(new io.realm.com_boardinglabs_rumahcemara_outreach_models_WorkerRealmProxy());
            }
            if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Total7Day.class)) {
                return clazz.cast(new io.realm.com_boardinglabs_rumahcemara_outreach_models_Total7DayRealmProxy());
            }
            if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Rating.class)) {
                return clazz.cast(new io.realm.com_boardinglabs_rumahcemara_outreach_models_RatingRealmProxy());
            }
            if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class)) {
                return clazz.cast(new io.realm.com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxy());
            }
            if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Password.class)) {
                return clazz.cast(new io.realm.com_boardinglabs_rumahcemara_outreach_models_PasswordRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Profile.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxy.copyOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.Profile) obj, update, cache));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Group.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_GroupRealmProxy.copyOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.Group) obj, update, cache));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Appointment.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_AppointmentRealmProxy.copyOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.Appointment) obj, update, cache));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Register.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxy.copyOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.Register) obj, update, cache));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxy.copyOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile) obj, update, cache));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.User.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_UserRealmProxy.copyOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.User) obj, update, cache));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.ProviderWorker.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_ProviderWorkerRealmProxy.copyOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.ProviderWorker) obj, update, cache));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Worker.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_WorkerRealmProxy.copyOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.Worker) obj, update, cache));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Total7Day.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_Total7DayRealmProxy.copyOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.Total7Day) obj, update, cache));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Rating.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_RatingRealmProxy.copyOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.Rating) obj, update, cache));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxy.copyOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.ServiceType) obj, update, cache));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Password.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_PasswordRealmProxy.copyOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.Password) obj, update, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Profile.class)) {
            io.realm.com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxy.insert(realm, (com.boardinglabs.rumahcemara.outreach.models.Profile) object, cache);
        } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Group.class)) {
            io.realm.com_boardinglabs_rumahcemara_outreach_models_GroupRealmProxy.insert(realm, (com.boardinglabs.rumahcemara.outreach.models.Group) object, cache);
        } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Appointment.class)) {
            io.realm.com_boardinglabs_rumahcemara_outreach_models_AppointmentRealmProxy.insert(realm, (com.boardinglabs.rumahcemara.outreach.models.Appointment) object, cache);
        } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Register.class)) {
            io.realm.com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxy.insert(realm, (com.boardinglabs.rumahcemara.outreach.models.Register) object, cache);
        } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile.class)) {
            io.realm.com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxy.insert(realm, (com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile) object, cache);
        } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.User.class)) {
            io.realm.com_boardinglabs_rumahcemara_outreach_models_UserRealmProxy.insert(realm, (com.boardinglabs.rumahcemara.outreach.models.User) object, cache);
        } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.ProviderWorker.class)) {
            io.realm.com_boardinglabs_rumahcemara_outreach_models_ProviderWorkerRealmProxy.insert(realm, (com.boardinglabs.rumahcemara.outreach.models.ProviderWorker) object, cache);
        } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Worker.class)) {
            io.realm.com_boardinglabs_rumahcemara_outreach_models_WorkerRealmProxy.insert(realm, (com.boardinglabs.rumahcemara.outreach.models.Worker) object, cache);
        } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Total7Day.class)) {
            io.realm.com_boardinglabs_rumahcemara_outreach_models_Total7DayRealmProxy.insert(realm, (com.boardinglabs.rumahcemara.outreach.models.Total7Day) object, cache);
        } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Rating.class)) {
            io.realm.com_boardinglabs_rumahcemara_outreach_models_RatingRealmProxy.insert(realm, (com.boardinglabs.rumahcemara.outreach.models.Rating) object, cache);
        } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class)) {
            io.realm.com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxy.insert(realm, (com.boardinglabs.rumahcemara.outreach.models.ServiceType) object, cache);
        } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Password.class)) {
            io.realm.com_boardinglabs_rumahcemara_outreach_models_PasswordRealmProxy.insert(realm, (com.boardinglabs.rumahcemara.outreach.models.Password) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Profile.class)) {
                io.realm.com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxy.insert(realm, (com.boardinglabs.rumahcemara.outreach.models.Profile) object, cache);
            } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Group.class)) {
                io.realm.com_boardinglabs_rumahcemara_outreach_models_GroupRealmProxy.insert(realm, (com.boardinglabs.rumahcemara.outreach.models.Group) object, cache);
            } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Appointment.class)) {
                io.realm.com_boardinglabs_rumahcemara_outreach_models_AppointmentRealmProxy.insert(realm, (com.boardinglabs.rumahcemara.outreach.models.Appointment) object, cache);
            } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Register.class)) {
                io.realm.com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxy.insert(realm, (com.boardinglabs.rumahcemara.outreach.models.Register) object, cache);
            } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile.class)) {
                io.realm.com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxy.insert(realm, (com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile) object, cache);
            } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.User.class)) {
                io.realm.com_boardinglabs_rumahcemara_outreach_models_UserRealmProxy.insert(realm, (com.boardinglabs.rumahcemara.outreach.models.User) object, cache);
            } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.ProviderWorker.class)) {
                io.realm.com_boardinglabs_rumahcemara_outreach_models_ProviderWorkerRealmProxy.insert(realm, (com.boardinglabs.rumahcemara.outreach.models.ProviderWorker) object, cache);
            } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Worker.class)) {
                io.realm.com_boardinglabs_rumahcemara_outreach_models_WorkerRealmProxy.insert(realm, (com.boardinglabs.rumahcemara.outreach.models.Worker) object, cache);
            } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Total7Day.class)) {
                io.realm.com_boardinglabs_rumahcemara_outreach_models_Total7DayRealmProxy.insert(realm, (com.boardinglabs.rumahcemara.outreach.models.Total7Day) object, cache);
            } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Rating.class)) {
                io.realm.com_boardinglabs_rumahcemara_outreach_models_RatingRealmProxy.insert(realm, (com.boardinglabs.rumahcemara.outreach.models.Rating) object, cache);
            } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class)) {
                io.realm.com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxy.insert(realm, (com.boardinglabs.rumahcemara.outreach.models.ServiceType) object, cache);
            } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Password.class)) {
                io.realm.com_boardinglabs_rumahcemara_outreach_models_PasswordRealmProxy.insert(realm, (com.boardinglabs.rumahcemara.outreach.models.Password) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Profile.class)) {
                    io.realm.com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Group.class)) {
                    io.realm.com_boardinglabs_rumahcemara_outreach_models_GroupRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Appointment.class)) {
                    io.realm.com_boardinglabs_rumahcemara_outreach_models_AppointmentRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Register.class)) {
                    io.realm.com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile.class)) {
                    io.realm.com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.User.class)) {
                    io.realm.com_boardinglabs_rumahcemara_outreach_models_UserRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.ProviderWorker.class)) {
                    io.realm.com_boardinglabs_rumahcemara_outreach_models_ProviderWorkerRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Worker.class)) {
                    io.realm.com_boardinglabs_rumahcemara_outreach_models_WorkerRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Total7Day.class)) {
                    io.realm.com_boardinglabs_rumahcemara_outreach_models_Total7DayRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Rating.class)) {
                    io.realm.com_boardinglabs_rumahcemara_outreach_models_RatingRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class)) {
                    io.realm.com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Password.class)) {
                    io.realm.com_boardinglabs_rumahcemara_outreach_models_PasswordRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Profile.class)) {
            io.realm.com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxy.insertOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.Profile) obj, cache);
        } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Group.class)) {
            io.realm.com_boardinglabs_rumahcemara_outreach_models_GroupRealmProxy.insertOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.Group) obj, cache);
        } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Appointment.class)) {
            io.realm.com_boardinglabs_rumahcemara_outreach_models_AppointmentRealmProxy.insertOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.Appointment) obj, cache);
        } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Register.class)) {
            io.realm.com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxy.insertOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.Register) obj, cache);
        } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile.class)) {
            io.realm.com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxy.insertOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile) obj, cache);
        } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.User.class)) {
            io.realm.com_boardinglabs_rumahcemara_outreach_models_UserRealmProxy.insertOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.User) obj, cache);
        } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.ProviderWorker.class)) {
            io.realm.com_boardinglabs_rumahcemara_outreach_models_ProviderWorkerRealmProxy.insertOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.ProviderWorker) obj, cache);
        } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Worker.class)) {
            io.realm.com_boardinglabs_rumahcemara_outreach_models_WorkerRealmProxy.insertOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.Worker) obj, cache);
        } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Total7Day.class)) {
            io.realm.com_boardinglabs_rumahcemara_outreach_models_Total7DayRealmProxy.insertOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.Total7Day) obj, cache);
        } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Rating.class)) {
            io.realm.com_boardinglabs_rumahcemara_outreach_models_RatingRealmProxy.insertOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.Rating) obj, cache);
        } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class)) {
            io.realm.com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxy.insertOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.ServiceType) obj, cache);
        } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Password.class)) {
            io.realm.com_boardinglabs_rumahcemara_outreach_models_PasswordRealmProxy.insertOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.Password) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Profile.class)) {
                io.realm.com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxy.insertOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.Profile) object, cache);
            } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Group.class)) {
                io.realm.com_boardinglabs_rumahcemara_outreach_models_GroupRealmProxy.insertOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.Group) object, cache);
            } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Appointment.class)) {
                io.realm.com_boardinglabs_rumahcemara_outreach_models_AppointmentRealmProxy.insertOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.Appointment) object, cache);
            } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Register.class)) {
                io.realm.com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxy.insertOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.Register) object, cache);
            } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile.class)) {
                io.realm.com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxy.insertOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile) object, cache);
            } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.User.class)) {
                io.realm.com_boardinglabs_rumahcemara_outreach_models_UserRealmProxy.insertOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.User) object, cache);
            } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.ProviderWorker.class)) {
                io.realm.com_boardinglabs_rumahcemara_outreach_models_ProviderWorkerRealmProxy.insertOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.ProviderWorker) object, cache);
            } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Worker.class)) {
                io.realm.com_boardinglabs_rumahcemara_outreach_models_WorkerRealmProxy.insertOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.Worker) object, cache);
            } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Total7Day.class)) {
                io.realm.com_boardinglabs_rumahcemara_outreach_models_Total7DayRealmProxy.insertOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.Total7Day) object, cache);
            } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Rating.class)) {
                io.realm.com_boardinglabs_rumahcemara_outreach_models_RatingRealmProxy.insertOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.Rating) object, cache);
            } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class)) {
                io.realm.com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxy.insertOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.ServiceType) object, cache);
            } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Password.class)) {
                io.realm.com_boardinglabs_rumahcemara_outreach_models_PasswordRealmProxy.insertOrUpdate(realm, (com.boardinglabs.rumahcemara.outreach.models.Password) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Profile.class)) {
                    io.realm.com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Group.class)) {
                    io.realm.com_boardinglabs_rumahcemara_outreach_models_GroupRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Appointment.class)) {
                    io.realm.com_boardinglabs_rumahcemara_outreach_models_AppointmentRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Register.class)) {
                    io.realm.com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile.class)) {
                    io.realm.com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.User.class)) {
                    io.realm.com_boardinglabs_rumahcemara_outreach_models_UserRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.ProviderWorker.class)) {
                    io.realm.com_boardinglabs_rumahcemara_outreach_models_ProviderWorkerRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Worker.class)) {
                    io.realm.com_boardinglabs_rumahcemara_outreach_models_WorkerRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Total7Day.class)) {
                    io.realm.com_boardinglabs_rumahcemara_outreach_models_Total7DayRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Rating.class)) {
                    io.realm.com_boardinglabs_rumahcemara_outreach_models_RatingRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class)) {
                    io.realm.com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Password.class)) {
                    io.realm.com_boardinglabs_rumahcemara_outreach_models_PasswordRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Profile.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Group.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_GroupRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Appointment.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_AppointmentRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Register.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.User.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_UserRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.ProviderWorker.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_ProviderWorkerRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Worker.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_WorkerRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Total7Day.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_Total7DayRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Rating.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_RatingRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Password.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_PasswordRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Profile.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Group.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_GroupRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Appointment.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_AppointmentRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Register.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.User.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_UserRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.ProviderWorker.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_ProviderWorkerRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Worker.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_WorkerRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Total7Day.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_Total7DayRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Rating.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_RatingRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Password.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_PasswordRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Profile.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxy.createDetachedCopy((com.boardinglabs.rumahcemara.outreach.models.Profile) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Group.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_GroupRealmProxy.createDetachedCopy((com.boardinglabs.rumahcemara.outreach.models.Group) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Appointment.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_AppointmentRealmProxy.createDetachedCopy((com.boardinglabs.rumahcemara.outreach.models.Appointment) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Register.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_RegisterRealmProxy.createDetachedCopy((com.boardinglabs.rumahcemara.outreach.models.Register) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxy.createDetachedCopy((com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.User.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_UserRealmProxy.createDetachedCopy((com.boardinglabs.rumahcemara.outreach.models.User) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.ProviderWorker.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_ProviderWorkerRealmProxy.createDetachedCopy((com.boardinglabs.rumahcemara.outreach.models.ProviderWorker) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Worker.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_WorkerRealmProxy.createDetachedCopy((com.boardinglabs.rumahcemara.outreach.models.Worker) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Total7Day.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_Total7DayRealmProxy.createDetachedCopy((com.boardinglabs.rumahcemara.outreach.models.Total7Day) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Rating.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_RatingRealmProxy.createDetachedCopy((com.boardinglabs.rumahcemara.outreach.models.Rating) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.ServiceType.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_ServiceTypeRealmProxy.createDetachedCopy((com.boardinglabs.rumahcemara.outreach.models.ServiceType) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.boardinglabs.rumahcemara.outreach.models.Password.class)) {
            return clazz.cast(io.realm.com_boardinglabs_rumahcemara_outreach_models_PasswordRealmProxy.createDetachedCopy((com.boardinglabs.rumahcemara.outreach.models.Password) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
