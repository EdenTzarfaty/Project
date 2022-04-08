package com.example.demo2;

import org.springframework.data.annotation.Id;
import java.sql.Timestamp;

public class Hospitalized {
    @Id
    private int _id;
    private Timestamp data;
    private int hospitalized;
    private int perWomenHospitalized;
    private int averageAgeHospitalized;
    private int ageStandarDeviationHos;
    private String respirators;
    private int averageAgeRespirators;;
    private int ageStandarDeviationRes;
    private int perUnvaccinatedRespirators;
    private int mildPatients;
    private int perWomenmildPatients;
    private int permildPatientsUnvaccinated;


    public Hospitalized() {
    }

    public Hospitalized(int _id, Timestamp data, int hospitalized, int perWomenHospitalized, int averageAgeHospitalized, int ageStandarDeviationHos, String respirators, int averageAgeRespirators, int ageStandarDeviationRes, int percentageUnvaccinatedRespirators, int mildPatients, int perWomenmildPatients, int permildPatientsUnvaccinated) {
        this._id = _id;
        this.data = data;
        this.hospitalized = hospitalized;
        this.perWomenHospitalized = perWomenHospitalized;
        this.averageAgeHospitalized = averageAgeHospitalized;
        this.ageStandarDeviationHos = ageStandarDeviationHos;
        this.respirators = respirators;
        this.averageAgeRespirators = averageAgeRespirators;
        this.ageStandarDeviationRes = ageStandarDeviationRes;
        this.perUnvaccinatedRespirators = percentageUnvaccinatedRespirators;
        this.mildPatients = mildPatients;
        this.perWomenmildPatients = perWomenmildPatients;
        this.permildPatientsUnvaccinated = permildPatientsUnvaccinated;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public int getHospitalized() {
        return hospitalized;
    }

    public void setHospitalized(int hospitalized) {
        this.hospitalized = hospitalized;
    }

    public int getPerWomenHospitalized() {
        return perWomenHospitalized;
    }

    public void setPerWomenHospitalized(int perWomenHospitalized) {
        this.perWomenHospitalized = perWomenHospitalized;
    }

    public int getAverageAgeHospitalized() {
        return averageAgeHospitalized;
    }

    public void setAverageAgeHospitalized(int averageAgeHospitalized) {
        this.averageAgeHospitalized = averageAgeHospitalized;
    }

    public int getAgeStandarDeviationHos() {
        return ageStandarDeviationHos;
    }

    public void setAgeStandarDeviationHos(int ageStandarDeviationHos) {
        this.ageStandarDeviationHos = ageStandarDeviationHos;
    }

    public String getRespirators() {
        return respirators;
    }

    public void setRespirators(String respirators) {
        this.respirators = respirators;
    }

    public int getAverageAgeRespirators() {
        return averageAgeRespirators;
    }

    public void setAverageAgeRespirators(int averageAgeRespirators) {
        this.averageAgeRespirators = averageAgeRespirators;
    }

    public int getAgeStandarDeviationRes() {
        return ageStandarDeviationRes;
    }

    public void setAgeStandarDeviationRes(int ageStandarDeviationRes) {
        this.ageStandarDeviationRes = ageStandarDeviationRes;
    }

    public int getPerUnvaccinatedRespirators() {
        return perUnvaccinatedRespirators;
    }

    public void setPerUnvaccinatedRespirators(int perUnvaccinatedRespirators) {
        this.perUnvaccinatedRespirators = perUnvaccinatedRespirators;
    }

    public int getMildPatients() {
        return mildPatients;
    }

    public void setMildPatients(int mildPatients) {
        this.mildPatients = mildPatients;
    }

    public int getPerWomenmildPatients() {
        return perWomenmildPatients;
    }

    public void setPerWomenmildPatients(int perWomenmildPatients) {
        this.perWomenmildPatients = perWomenmildPatients;
    }

    public int getPermildPatientsUnvaccinated() {
        return permildPatientsUnvaccinated;
    }

    public void setPermildPatientsUnvaccinated(int permildPatientsUnvaccinated) {
        this.permildPatientsUnvaccinated = permildPatientsUnvaccinated;
    }
}
