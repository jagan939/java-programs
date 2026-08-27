import java.util.*;

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {

    public List<Student> getStudents(List<String> events) {

        PriorityQueue<Student> pq = new PriorityQueue<>(
            (a, b) -> {
                if (Double.compare(b.getCGPA(), a.getCGPA()) != 0)
                    return Double.compare(b.getCGPA(), a.getCGPA());

                if (!a.getName().equals(b.getName()))
                    return a.getName().compareTo(b.getName());

                return a.getID() - b.getID();
            }
        );

        for (String event : events) {
            String[] arr = event.split(" ");

            if (arr[0].equals("ENTER")) {
                String name = arr[1];
                double cgpa = Double.parseDouble(arr[2]);
                int id = Integer.parseInt(arr[3]);

                pq.offer(new Student(id, name, cgpa));
            } else {
                if (!pq.isEmpty()) {
                    pq.poll();
                }
            }
        }

        List<Student> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        return result;
    }
}
