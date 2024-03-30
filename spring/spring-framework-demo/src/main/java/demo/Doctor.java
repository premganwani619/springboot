package demo;

public class Doctor implements Staff{
    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    Nurse nurse;



    public String getQualification() {
        return qualification;
    }

    public Doctor(String random) {
        this.random = random;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }


    public String qualification;
    public String random;

    public String getRandom() {
        return random;
    }


    @Override
    public void assist() {
        System.out.println("Doctor is assisting");
    }
}
