import java.util.ArrayList;
import java.util.List;

class Point {
    private float lat;
    private float lng;

    public Point(float lat, float lng) {
        this.lat = lat;
        this.lng = lng;
    }
    public float getLat() {
        return this.lat;
    }

    public float getLng() {
        return this.lng;
    }
}

class BusinessData {
    private Point coordinate;
    private Integer value;

    public BusinessData (Point coordinate, int value) {
        this.coordinate = coordinate;
        this.value = value;
    }

    public Point getCoordinate() {
        return this.coordinate;
    }

    public Integer getValue() {
        return this.value;
    }
}

class Node {
    private Point topLeft;
    private Point bottomRight;
    private List<BusinessData> datas;
    private Node topLeftNode;
    private Node topRightNode;
    private Node bottomLeftNode;
    private Node bottomRightNode;

    public Node(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        datas = new ArrayList<>();
    }

    boolean isInside(Point point) {
        return (point.getLat() >= topLeft.getLat() && point.getLat() <= bottomRight.getLat())
                && (point.getLng()>= bottomRight.getLng() && point.getLng() <= topLeft.getLng());
    }

    public void addData(BusinessData data) {
        datas.add(data);
    }

    public void doPartition() {
        float latMid = (topLeft.getLat() + bottomRight.getLat())/2;
        float lngMid = (topLeft.getLng() + bottomRight.getLng())/2;
        topLeftNode = new Node(topLeft, new Point(latMid, lngMid));
        topRightNode = new Node(new Point(latMid, topLeft.getLng()), new Point(topLeft.getLat(), lngMid));
        bottomLeftNode = new Node(new Point(topLeft.getLat(), lngMid), new Point(latMid, bottomRight.getLng()));
        bottomRightNode = new Node(new Point(latMid, lngMid), bottomRight);
    }

    public Node getTopLeftNode(){
        return this.topLeftNode;
    }

    public Node getTopRightNode() {
        return this.topRightNode;
    }

    public Node getBottomLeftNode() {
        return this.getTopLeftNode();
    }

    public Node getBottomRightNode() {
        return this.bottomRightNode;
    }
}

public class QuadTree {
    public static void main(String[] args) {
        Node quadTree = new Node(new Point(-180,90), new Point(180,-90));
        quadTree.doPartition();
        quadTree.getTopLeftNode().doPartition();
        quadTree.getTopLeftNode().getTopLeftNode().doPartition();

        System.out.println("Hold");

    }
}
