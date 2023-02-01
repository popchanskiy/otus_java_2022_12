package homework;

public class Customer  {
    private final long id;
    private String name;
    private long scores;
    public static final int MAX_SCORE = 888;

    public Customer(Customer customer) {
       id = customer.getId();
       name= customer.getName();
       scores=customer.getScores();
    }

    public Customer(long id, String name, long scores) {
        this.id = id;
        this.name = name;
        this.scores = scores;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getScores() {
        return scores;
    }

    public void setScores(long scores) {
      this.scores= scores > MAX_SCORE ? MAX_SCORE: scores;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", scores=" + scores +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;
        return scores == customer.getScores()||id==customer.getId();
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

}
