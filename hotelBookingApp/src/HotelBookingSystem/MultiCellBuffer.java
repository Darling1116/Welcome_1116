package HotelBookingSystem;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 * MultiCellBuffer类用于旅行社(客户端)和HotelSupplier(服务器)之间的通信:这个类有2个数据单元。
 * 可用的单元格数必须小于(<)试验中旅行社的最大数量。
 * 可以定义setOneCell和getOneCell方法来将数据写入或从一个可用单元格中读取数据。
 * 您必须使用值n的semaphore来管理单元，并对每个缓冲区单元使用锁。
 * 不能对缓冲区使用队列，因为它是一种不同的数据结构。
 * 该信号量将允许代理获得对其中一个缓冲区单元进行写操作的权限。
 * 但是酒店供应商仍然可以同时阅读。同步也是必需的。(10分)
 */


public class MultiCellBuffer {

    //私有化构造器
    private MultiCellBuffer() {}

    //内部创建类的对象
    private static MultiCellBuffer instance = new MultiCellBuffer();

    //提供公共的方法，返回类的对象
    public static MultiCellBuffer getInstance() {
        return instance;
    }

    /**
     * 非阻塞队列中的几个主要方法：
     *
     * add(E e) : 将元素e插入到队列末尾，如果插入成功，则返回true；如果插入失败（即队列已满），则会抛出异常；
     * remove() ：移除队首元素，若移除成功，则返回true；如果移除失败（队列为空），则会抛出异常；
     * offer(E e) ：将元素e插入到队列末尾，如果插入成功，则返回true；如果插入失败（即队列已满），则返回false；
     * poll() ：移除并获取队首元素，若成功，则返回队首元素；否则返回null；
     * peek() ：获取队首元素，若成功，则返回队首元素；否则返回null
     *
     * 对于非阻塞队列，一般情况下建议使用offer、poll和peek三个方法，不建议使用add和remove方法。
     * 因为使用offer、poll和peek三个方法可以通过返回值判断操作成功与否，而使用add和remove方法却不能达到这样的效果。
     * 注意，非阻塞队列中的方法都没有进行同步措施。
     */

    public static int MAXCELL = 2;
    private Queue<String> buffer = new LinkedList<String>();

    public boolean isEmpty() {

        return buffer.isEmpty();
    }

    public boolean isFull() {

        return (buffer.size()==MAXCELL);
    }

    public void setOneCell (String str) {

        buffer.offer(str);

    }
    public String getOneCell() {

        return buffer.poll();
    }

    public String readCells() {
        StringBuilder str = new StringBuilder("");
        str.append(buffer.peek());
        return str.toString();
    }

}
