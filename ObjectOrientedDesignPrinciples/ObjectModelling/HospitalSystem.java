import java.util.*;

class Patient {
    private String name;
    private List<Doctor> doctors = new ArrayList<>();

    public Patient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    public void showDoctors() {
        System.out.println(name + " consulted the following doctors:");
        for (Doctor d : doctors) {
            System.out.println("- " + d.getName());
        }
    }
}

class Doctor {
    private String name;
    private List<Patient> patients = new ArrayList<>();

    public Doctor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Communication: Doctor consults with a patient
    public void consult(Patient patient) {
        System.out.println("Dr. " + name + " is consulting patient " + patient.getName());
        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.addDoctor(this); // two-way association
        }
    }

    public void showPatients() {
        System.out.println("Dr. " + name + " has consulted:");
        for (Patient p : patients) {
            System.out.println("- " + p.getName());
        }
    }
}

public class HospitalSystem {
    public static void main(String[] args) {
        Doctor drSharma = new Doctor("Sharma");
        Doctor drKhan = new Doctor("Khan");

        Patient rohit = new Patient("Rohit");
        Patient maya = new Patient("Maya");

        drSharma.consult(rohit);
        drSharma.consult(maya);
        drKhan.consult(maya);

        drSharma.showPatients();
        drKhan.showPatients();
        rohit.showDoctors();
        maya.showDoctors();
    }
}
