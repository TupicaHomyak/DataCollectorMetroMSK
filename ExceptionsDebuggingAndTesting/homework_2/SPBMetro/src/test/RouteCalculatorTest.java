import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    public class RouteCalculatorTest extends TestCase {

    List<Station> route;
    RouteCalculator routeCalculator;
    StationIndex stationIndex;

        @Override
        protected void setUp() throws  Exception {
            stationIndex = new StationIndex();
            route = new ArrayList<>();

            // Создаем линии метро
            Line line1 = new Line(1, "Синяя ветка");
            Line line2 = new Line(2, "Роузовая ветка");
            Line line3 = new Line(3, "Красная ветка");

            // Добавляем станции на линии
            Station station1 = new Station("Первомайская", line1);
            Station station2 = new Station("Измайловская", line1);
            Station station3 = new Station("Партизанская", line1);
            line1.addStation(station1);
            line1.addStation(station2);
            line1.addStation(station3);

            Station station4 = new Station("Измайлово", line2);
            Station station5 = new Station("Локомотив", line2);
            Station station6 = new Station("Бульвар", line2);
            line2.addStation(station4);
            line2.addStation(station5);
            line2.addStation(station6);

            Station station7 = new Station("Рокоссовского", line3);
            Station station8 = new Station("Локомотив", line3);
            Station station9 = new Station("Преображенская", line3);
            line3.addStation(station7);
            line3.addStation(station8);
            line3.addStation(station9);

            //добавляем линии в метро
            stationIndex.addLine(line1);
            stationIndex.addLine(line2);
            stationIndex.addLine(line3);

            //добавляем станции в метро
            stationIndex.addStation(station1);
            stationIndex.addStation(station2);
            stationIndex.addStation(station3);

            stationIndex.addStation(station4);
            stationIndex.addStation(station5);
            stationIndex.addStation(station6);

            stationIndex.addStation(station7);
            stationIndex.addStation(station8);
            stationIndex.addStation(station9);

            // точки пересечения
            stationIndex.addConnection(new ArrayList<>(Arrays.asList(station3,station4)));
            stationIndex.addConnection(new ArrayList<>(Arrays.asList(station6,station7)));

            routeCalculator = new RouteCalculator(stationIndex);

            //задаем маршрут для теста testCalculateDuration()
            route.add(station1);
            route.add(station2);
            route.add(station3);
            route.add(station4);
            route.add(station5);
            route.add(station6);
            route.add(station7);
            route.add(station8);
            route.add(station9);


        }
        @Test
        // Тест на проверку правильности расчета времени
        public void testCalculateDuration()
        {
            double actual = RouteCalculator.calculateDuration(route);
            double expected = 22.0;
            assertEquals(expected, actual);

            System.out.println(expected);
            System.out.println(actual);
        }

        @Test
        public void testGetRouteOnTheLine() {
            // Тест на поиск маршрута на одной линии
            List<Station> actual = routeCalculator.getShortestRoute(route.get(0), route.get(2));
            List<Station> expected = new ArrayList<>();
            expected.add(route.get(0));
            expected.add(route.get(1));
            expected.add(route.get(2));
            assertEquals(expected, actual);

            System.out.println(expected);
            System.out.println(actual);
        }

        @Test
        public void testGetRouteWithOneConnection() {
            // Тест на поиск маршрута с одной пересадкой
            List<Station> actual = routeCalculator.getShortestRoute(route.get(0), route.get(3));
            List<Station> expected = new ArrayList<>();
            expected.add(route.get(0));
            expected.add(route.get(1));
            expected.add(route.get(2));
            expected.add(route.get(3));
            assertEquals(expected, actual);

            System.out.println(expected);
            System.out.println(actual);
        }

        @Test
        public void testGetRouteWithTwoConnections() {
            // Тест на поиск маршрута с двумя пересадками
            List<Station> actual = routeCalculator.getRouteWithTwoConnections(route.get(0), route.get(8));
            List<Station> expected = new ArrayList<>();
            expected.add(route.get(0));
            expected.add(route.get(1));
            expected.add(route.get(2));
            expected.add(route.get(3));
            expected.add(route.get(4));
            expected.add(route.get(5));
            expected.add(route.get(6));
            expected.add(route.get(7));
            expected.add(route.get(8));
            assertEquals(expected, actual);

            System.out.println(expected);
            System.out.println(actual);
        }
    }