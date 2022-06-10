package Java.综合案例.黑马案例.ui;

import Java.综合案例.黑马案例.component.BookManageComponent;
import Java.综合案例.黑马案例.util.PathUtils;
import Java.综合案例.黑马案例.util.ScreenUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ManagerInterface {
    JFrame jf = new JFrame("黑马图书馆: " + MainInterface.name + "欢迎你");
    final int WIDTH = 1000;
    final int HEIGHT = 600;

    //组装视图
    public void init() throws Exception {

        //给窗口设置属性
        jf.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);
        jf.setResizable(false);
        jf.setIconImage(ImageIO.read(new File(PathUtils.getRealPath("bg.png"))));

        //设置菜单栏
        JMenuBar jmb = new JMenuBar();
        JMenu jMenu = new JMenu("设置");
        JMenuItem m1 = new JMenuItem("切换账号");
        JMenuItem m2 = new JMenuItem("退出程序");
        m1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new MainInterface().init();
                    jf.dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        m2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jMenu.add(m1);
        jMenu.add(m2);
        jmb.add(jMenu);

        jf.setJMenuBar(jmb);

        //设置分割面板
        JSplitPane sp = new JSplitPane();
        //支持连续布局
        sp.setContinuousLayout(true);
        sp.setDividerLocation(150);
        sp.setDividerSize(7);

        //设置左侧内容
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("系统管理");
        DefaultMutableTreeNode userManage = new DefaultMutableTreeNode("用户管理");
        DefaultMutableTreeNode bookManage = new DefaultMutableTreeNode("图书管理");
        DefaultMutableTreeNode borrowManage = new DefaultMutableTreeNode("借阅管理");
        DefaultMutableTreeNode statisticsManage = new DefaultMutableTreeNode("统计分析");

        root.add(userManage);
        root.add(bookManage);
        root.add(borrowManage);
        root.add(statisticsManage);

        Color color = new Color(203,220,217);
        JTree tree = new JTree(root);
        MyRenderer myRenderer = new MyRenderer();
        myRenderer.setBackgroundNonSelectionColor(color);
        myRenderer.setBackgroundSelectionColor(new Color(140,140,140));

        tree.setCellRenderer(myRenderer);
        tree.setBackground(color);
        //设置当前tree默认选中图书管理
        tree.setSelectionRow(2);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            //当条目选中变化后，这个方法会执行
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //得到当前选中的结点对象
                Object lastPathComponent = e.getNewLeadSelectionPath().getLastPathComponent();
                if (userManage.equals(lastPathComponent)) {
                    sp.setRightComponent(new JLabel("这里进行用户管理..."));
                    sp.setDividerLocation(150);
                } else if (bookManage.equals(lastPathComponent)) {
                    sp.setRightComponent(new BookManageComponent(jf));
                    sp.setDividerLocation(150);
                } else if (borrowManage.equals(lastPathComponent)) {
                    sp.setRightComponent(new JLabel("这里进行借阅管理..."));
                    sp.setDividerLocation(150);
                } else if (statisticsManage.equals(lastPathComponent)) {
                    sp.setRightComponent(new JLabel("这里进行统计分析..."));
                    sp.setDividerLocation(150);
                }
            }
        });


        sp.setRightComponent(new BookManageComponent(jf));
        sp.setLeftComponent(tree);


        jf.add(sp);
        jf.setVisible(true);
    }

    //自定义结点绘制器
    private class MyRenderer extends DefaultTreeCellRenderer {
        private ImageIcon rootIcon = null;
        private ImageIcon userManageIcon = null;
        private ImageIcon bookManageIcon = null;
        private ImageIcon borrowManageIcon = null;
        private ImageIcon statisticsManageIcon = null;

        public MyRenderer() {
            rootIcon = new ImageIcon(PathUtils.getRealPath("smile1.png"));
            userManageIcon = new ImageIcon(PathUtils.getRealPath("smile2.png"));
            bookManageIcon = new ImageIcon(PathUtils.getRealPath("smile1.png"));
            borrowManageIcon = new ImageIcon(PathUtils.getRealPath("smile1.png"));
            statisticsManageIcon = new ImageIcon(PathUtils.getRealPath("smile2.png"));
        }

        //当绘制树的每个结点时，都会调用这个方法
        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            //使用默认绘制
            super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

            ImageIcon image = null;
            switch (row) {
                case 0:
                    image = rootIcon;
                    break;
                case 1:
                    image = userManageIcon;
                    break;
                case 2:
                    image = bookManageIcon;
                    break;
                case 3:
                    image = borrowManageIcon;
                    break;
                case 4:
                    image = statisticsManageIcon;
                    break;
            }

            this.setIcon(image);

            return this;
        }
    }
}
