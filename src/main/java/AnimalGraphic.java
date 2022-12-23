import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ui.ApplicationFrame;

public class AnimalGraphic extends ApplicationFrame {
    public AnimalGraphic(String title) {
        super(title);
        setContentPane(createPanel());
    }

    public JPanel createPanel() {
        return new ChartPanel(createChart(createDataset()));
    }

    private CategoryDataset createDataset() {
        var dataset = new DefaultCategoryDataset();
        var animals = CsvGenerator.getAnimals("C:\\Users\\vinni\\Documents\\IdeaProjects\\JavaProject\\src\\main\\resources\\Data.csv");
        for (var animal:
             animals) {
            dataset.addValue(animal.getWeight(), animal.getBreed(), animal.getTypeAnimal());
        }
        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {
        var chart = ChartFactory.createBarChart(
                "Зависимость веса от породы животного",
                null,
                "Weight",
                dataset);
        chart.setBackgroundPaint(Color.white);
        return chart;
    }

    public static void getGraphic() {
        var graphic = new AnimalGraphic("Животные");
        graphic.pack();
        graphic.setVisible(true);
    }
}
