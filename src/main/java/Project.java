import java.util.Arrays;

/**
 * @author Juri Adams (@4dams)
 * @author Felix Rein
 * 
 * @version 1.0.0-Snapshot
 * 
 * Class Project
 * Creates Project Objects
 * extends ProjectComponents
 * 
 */
public class Project extends ProjectComponent {
/**
 * Method setHourlyRate()
 * Sets the hourlyRate of Project
 * 
 */
    @Override
    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
/**
 * Method getHourlyRate()
 * Returns the HourlyRate.
 */
    @Override
    public float getHourlyRate() {
        return this.hourlyRate;
    }
/**
 * Method addComponent()
 * Adds a component to the components Array.
 */

    @Override
    public ProjectComponent[] addComponent(ProjectComponent component) {
        this.components = Arrays.copyOf(this.components, this.components.length + 1);
        this.components[this.components.length - 1] = component;

        return this.components;
    }
/**
 * Constructor Project
 * Creates a Project Object.
 * @param name
 * Name of the Project
 * @param description
 * Description of the Project
 * @param hourRate
 * Hour Rate of the Project
 */
    public Project(String name, String description, float hourRate) {
        this.setName(name);
        this.setDescription(description);
        this.setHourlyRate(hourRate);
    }

    /**
     * Calculate the cost of this Project
     */
    @Override
    public float berechneKosten() {
        float total = 0;

        // Iterate through the components of this project
        for (ProjectComponent component : this.components) {
            if (component instanceof Project) {
                // System.out.println("DEBUG | component is of type `Project`");

                // Run this method again for the subproject
                total += component.berechneKosten();
            } else if (component instanceof Task) {
                // System.out.println("DEBUG | component is of type `Task`");

                // Add all billed hours to the total
                total += component.getBilledHours() * this.hourlyRate;
            } else if (component instanceof Product) {
                // System.out.println("DEBUG | component is of type `Product`");

                // Add the production cost to the total
                total += component.getProductionCost();
            }
        }

        System.out.println(String.format("INFO   | total for project %s: %s", this.getName(), total));

        return total;
    }

    public String toString(){
        return "Project" + this.name + ", " + "Stundensatz: " + this.hourlyRate;
    }

}
