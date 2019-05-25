package gr.aueb.se.labadministration.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import gr.aueb.se.labadministration.dao.LaboratoryDAO;
import gr.aueb.se.labadministration.dao.UserDAO;
import gr.aueb.se.labadministration.domain.people.User;
import gr.aueb.se.labadministration.memorydao.LaboratoryDAOMemory;
import gr.aueb.se.labadministration.memorydao.UserDAOMemory;
import gr.aueb.se.labadministration.utilities.RequestResult;

public class LabService extends Service {

    public class LabServiceBinder extends Binder {
        public LabService getService() {
            return LabService.this;
        }
    }

    private LaboratoryDAO laboratoryDAO;

    public LabService() {
        laboratoryDAO = new LaboratoryDAOMemory();
    }

    public LaboratoryDAO getLaboratoryDAO() {
        return laboratoryDAO;
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new LabServiceBinder();
    }
}