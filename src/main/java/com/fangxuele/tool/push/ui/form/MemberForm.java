package com.fangxuele.tool.push.ui.form;

import com.fangxuele.tool.push.App;
import com.fangxuele.tool.push.logic.PushData;
import com.fangxuele.tool.push.ui.listener.MemberListener;
import com.fangxuele.tool.push.util.UIUtil;
import com.fangxuele.tool.push.util.UndoUtil;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import lombok.Getter;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

/**
 * <pre>
 * MemberForm
 * </pre>
 *
 * @author <a href="https://github.com/rememberber">RememBerBer</a>
 * @since 2019/5/6.
 */
@Getter
public class MemberForm {
    private JPanel memberPanelRight;
    private JPanel memberTabUpPanel;
    private JLabel memberTabCountLabel;
    private JProgressBar memberTabImportProgressBar;
    private JButton clearImportButton;
    private JPanel memberTabDownPanel;
    private JLabel importFromFileLabel;
    private JTextField memberFilePathField;
    private JButton importFromFileButton;
    private JButton memberImportExploreButton;
    private JPanel memberTabCenterPanel;
    private JButton importFromSqlButton;
    private JButton memberImportTagButton;
    private JComboBox memberImportTagComboBox;
    private JButton memberImportTagFreshButton;
    private JButton memberImportTagRetainButton;
    private JButton memberImportAllButton;
    private JTable memberListTable;
    private JPanel memberPanel;
    private JButton selectAllButton;
    private JButton importSelectedButton;
    private JButton deleteButton;
    private JTextField searchTextField;
    private JButton searchButton;
    private JButton exportButton;
    private JPanel importFromWeixinPanel;
    private JCheckBox importOptionOpenIdCheckBox;
    private JCheckBox importOptionBasicInfoCheckBox;
    private JCheckBox importOptionAvatarCheckBox;
    private JPanel importOptionPanel;
    private JButton clearDbCacheButton;
    private JComboBox wxCpTagsComboBox;
    private JPanel importFromWxCpPanel;
    private JButton wxCpImportAllButton;
    private JButton wxCpTagsRefreshButton;
    private JButton wxCpTagsImportButton;
    private JComboBox wxCpDeptsComboBox;
    private JButton wxCpDeptsImportButton;
    private JButton wxCpDeptsRefreshButton;
    private JPanel importWayPanel;
    private JTextArea importFromSqlTextArea;
    private JScrollPane memberImportScrollPane;
    private JPanel importFromNumPanel;
    private JLabel 数量Label;
    private JTextField importNumTextField;
    private JButton importFromNumButton;
    private JSplitPane splitPane;
    private JButton dingImportAllButton;
    private JPanel importFromDingPanel;
    private JButton dingDeptsImportButton;
    private JComboBox dingDeptsComboBox;
    private JButton dingDeptsRefreshButton;
    private JButton memberImportTagExceptButton;

    private static MemberForm memberForm;

    private MemberForm() {
        UndoUtil.register(this);
    }

    public static MemberForm getInstance() {
        if (memberForm == null) {
            memberForm = new MemberForm();
        }
        return memberForm;
    }

    /**
     * 初始化导入用户tab
     */
    public static void init() {
        memberForm = getInstance();

        memberForm.getSplitPane().setDividerLocation((int) (App.mainFrame.getWidth() * 0.6));

        memberForm.getMemberImportScrollPane().getVerticalScrollBar().setUnitIncrement(15);
        memberForm.getMemberImportScrollPane().getVerticalScrollBar().setDoubleBuffered(true);

        memberForm.getMemberTabImportProgressBar().setVisible(false);
        memberForm.getImportFromSqlTextArea().setText(App.config.getMemberSql());
        memberForm.getMemberFilePathField().setText(App.config.getMemberFilePath());

        if (UIUtil.isDarkLaf()) {
            Color bgColor = new Color(43, 43, 43);
            memberForm.getImportFromSqlTextArea().setBackground(bgColor);
            Color foreColor = new Color(187, 187, 187);
            memberForm.getImportFromSqlTextArea().setForeground(foreColor);
        }
        clearMember();
    }

    /**
     * 清除
     */
    public static void clearMember() {
        memberForm = getInstance();

        PushData.allUser = Collections.synchronizedList(new ArrayList<>());
        PushData.allUser.clear();
        memberForm.getMemberTabCountLabel().setText("0");

        String[] headerNames = {"数据"};
        DefaultTableModel model = new DefaultTableModel(null, headerNames);
        memberForm.getMemberListTable().setModel(model);

        MemberListener.tagUserSet = null;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        memberPanel = new JPanel();
        memberPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        memberPanel.setMinimumSize(new Dimension(-1, -1));
        memberPanel.setOpaque(true);
        memberPanel.setPreferredSize(new Dimension(-1, -1));
        splitPane = new JSplitPane();
        splitPane.setContinuousLayout(true);
        splitPane.setDividerLocation(800);
        splitPane.setDividerSize(4);
        splitPane.setDoubleBuffered(true);
        splitPane.setLastDividerLocation(800);
        memberPanel.add(splitPane, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setMinimumSize(new Dimension(-1, -1));
        panel1.setPreferredSize(new Dimension(-1, -1));
        splitPane.setLeftComponent(panel1);
        final JScrollPane scrollPane1 = new JScrollPane();
        panel1.add(scrollPane1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        memberListTable = new JTable();
        memberListTable.setGridColor(new Color(-12236470));
        memberListTable.setMinimumSize(new Dimension(30, 30));
        memberListTable.setRowHeight(36);
        scrollPane1.setViewportView(memberListTable);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 5, new Insets(5, 5, 5, 0), -1, -1));
        panel1.add(panel2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        selectAllButton = new JButton();
        selectAllButton.setIcon(new ImageIcon(getClass().getResource("/icon/selectall_dark.png")));
        selectAllButton.setText("全选");
        panel2.add(selectAllButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        importSelectedButton = new JButton();
        importSelectedButton.setIcon(new ImageIcon(getClass().getResource("/icon/import_dark.png")));
        importSelectedButton.setText("导入");
        panel2.add(importSelectedButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        exportButton = new JButton();
        exportButton.setIcon(new ImageIcon(getClass().getResource("/icon/export_dark.png")));
        exportButton.setText("导出");
        panel2.add(exportButton, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        deleteButton = new JButton();
        deleteButton.setIcon(new ImageIcon(getClass().getResource("/icon/remove.png")));
        deleteButton.setText("删除");
        panel2.add(deleteButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel2.add(spacer1, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(1, 2, new Insets(5, 5, 0, 5), -1, -1));
        panel1.add(panel3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        searchTextField = new JTextField();
        panel3.add(searchTextField, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        searchButton = new JButton();
        searchButton.setIcon(new ImageIcon(getClass().getResource("/icon/find_dark.png")));
        searchButton.setText("搜索");
        panel3.add(searchButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel4.setMinimumSize(new Dimension(-1, -1));
        panel4.setPreferredSize(new Dimension(-1, -1));
        splitPane.setRightComponent(panel4);
        memberPanelRight = new JPanel();
        memberPanelRight.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel4.add(memberPanelRight, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        memberTabUpPanel = new JPanel();
        memberTabUpPanel.setLayout(new GridLayoutManager(2, 4, new Insets(0, 5, 5, 0), -1, -1));
        memberPanelRight.add(memberTabUpPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        memberTabCountLabel = new JLabel();
        Font memberTabCountLabelFont = this.$$$getFont$$$(null, -1, 72, memberTabCountLabel.getFont());
        if (memberTabCountLabelFont != null) memberTabCountLabel.setFont(memberTabCountLabelFont);
        memberTabCountLabel.setForeground(new Color(-276358));
        memberTabCountLabel.setText("0");
        memberTabUpPanel.add(memberTabCountLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        memberTabImportProgressBar = new JProgressBar();
        memberTabUpPanel.add(memberTabImportProgressBar, new GridConstraints(1, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        memberTabUpPanel.add(spacer2, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("已导入");
        memberTabUpPanel.add(label1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        clearImportButton = new JButton();
        clearImportButton.setText("清除");
        memberTabUpPanel.add(clearImportButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        memberImportScrollPane = new JScrollPane();
        memberPanelRight.add(memberImportScrollPane, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        importWayPanel = new JPanel();
        importWayPanel.setLayout(new GridLayoutManager(7, 1, new Insets(8, 0, 0, 0), -1, -1));
        importWayPanel.setMinimumSize(new Dimension(-1, -1));
        importWayPanel.setPreferredSize(new Dimension(150, 600));
        memberImportScrollPane.setViewportView(importWayPanel);
        memberTabDownPanel = new JPanel();
        memberTabDownPanel.setLayout(new GridLayoutManager(2, 3, new Insets(8, 15, 0, 5), -1, -1));
        importWayPanel.add(memberTabDownPanel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        memberTabDownPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), "通过文件导入", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, this.$$$getFont$$$(null, Font.BOLD, -1, memberTabDownPanel.getFont()), null));
        importFromFileLabel = new JLabel();
        importFromFileLabel.setHorizontalAlignment(11);
        importFromFileLabel.setHorizontalTextPosition(4);
        importFromFileLabel.setText("文件路径（*.txt,*.csv,*.xlsx）");
        memberTabDownPanel.add(importFromFileLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        memberFilePathField = new JTextField();
        memberTabDownPanel.add(memberFilePathField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        memberImportExploreButton = new JButton();
        memberImportExploreButton.setText("...");
        memberTabDownPanel.add(memberImportExploreButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        importFromFileButton = new JButton();
        importFromFileButton.setIcon(new ImageIcon(getClass().getResource("/icon/import_dark.png")));
        importFromFileButton.setText("导入");
        memberTabDownPanel.add(importFromFileButton, new GridConstraints(1, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        memberTabCenterPanel = new JPanel();
        memberTabCenterPanel.setLayout(new GridLayoutManager(2, 1, new Insets(8, 15, 0, 5), -1, -1));
        importWayPanel.add(memberTabCenterPanel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        memberTabCenterPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), "通过SQL导入", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, this.$$$getFont$$$(null, Font.BOLD, -1, memberTabCenterPanel.getFont()), null));
        importFromSqlButton = new JButton();
        importFromSqlButton.setIcon(new ImageIcon(getClass().getResource("/icon/import_dark.png")));
        importFromSqlButton.setText("导入");
        memberTabCenterPanel.add(importFromSqlButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        importFromSqlTextArea = new JTextArea();
        memberTabCenterPanel.add(importFromSqlTextArea, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(40, 50), null, 0, false));
        importFromWeixinPanel = new JPanel();
        importFromWeixinPanel.setLayout(new GridLayoutManager(5, 3, new Insets(0, 15, 0, 5), -1, -1));
        importWayPanel.add(importFromWeixinPanel, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        importFromWeixinPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "通过微信公众平台导入", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, this.$$$getFont$$$(null, Font.BOLD, -1, importFromWeixinPanel.getFont()), null));
        memberImportTagComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        memberImportTagComboBox.setModel(defaultComboBoxModel1);
        importFromWeixinPanel.add(memberImportTagComboBox, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        memberImportAllButton = new JButton();
        Font memberImportAllButtonFont = this.$$$getFont$$$(null, Font.PLAIN, -1, memberImportAllButton.getFont());
        if (memberImportAllButtonFont != null) memberImportAllButton.setFont(memberImportAllButtonFont);
        memberImportAllButton.setIcon(new ImageIcon(getClass().getResource("/icon/import_dark.png")));
        memberImportAllButton.setText("导入所有关注公众号的用户");
        importFromWeixinPanel.add(memberImportAllButton, new GridConstraints(4, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        memberImportTagFreshButton = new JButton();
        Font memberImportTagFreshButtonFont = this.$$$getFont$$$(null, Font.PLAIN, -1, memberImportTagFreshButton.getFont());
        if (memberImportTagFreshButtonFont != null) memberImportTagFreshButton.setFont(memberImportTagFreshButtonFont);
        memberImportTagFreshButton.setIcon(new ImageIcon(getClass().getResource("/icon/refresh.png")));
        memberImportTagFreshButton.setText("刷新");
        importFromWeixinPanel.add(memberImportTagFreshButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, 1, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        memberImportTagButton = new JButton();
        Font memberImportTagButtonFont = this.$$$getFont$$$(null, Font.PLAIN, -1, memberImportTagButton.getFont());
        if (memberImportTagButtonFont != null) memberImportTagButton.setFont(memberImportTagButtonFont);
        memberImportTagButton.setIcon(new ImageIcon(getClass().getResource("/icon/import_dark.png")));
        memberImportTagButton.setText("导入选择的标签分组-取并集");
        importFromWeixinPanel.add(memberImportTagButton, new GridConstraints(1, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        memberImportTagRetainButton = new JButton();
        Font memberImportTagRetainButtonFont = this.$$$getFont$$$(null, Font.PLAIN, -1, memberImportTagRetainButton.getFont());
        if (memberImportTagRetainButtonFont != null)
            memberImportTagRetainButton.setFont(memberImportTagRetainButtonFont);
        memberImportTagRetainButton.setIcon(new ImageIcon(getClass().getResource("/icon/import_dark.png")));
        memberImportTagRetainButton.setText("导入选择的标签分组-取交集");
        importFromWeixinPanel.add(memberImportTagRetainButton, new GridConstraints(2, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        memberImportTagExceptButton = new JButton();
        Font memberImportTagExceptButtonFont = this.$$$getFont$$$(null, Font.PLAIN, -1, memberImportTagExceptButton.getFont());
        if (memberImportTagExceptButtonFont != null)
            memberImportTagExceptButton.setFont(memberImportTagExceptButtonFont);
        memberImportTagExceptButton.setIcon(new ImageIcon(getClass().getResource("/icon/remove_dark.png")));
        memberImportTagExceptButton.setText("排除选择的标签分组");
        importFromWeixinPanel.add(memberImportTagExceptButton, new GridConstraints(3, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("标签分组");
        importFromWeixinPanel.add(label2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        importFromWxCpPanel = new JPanel();
        importFromWxCpPanel.setLayout(new GridLayoutManager(3, 4, new Insets(8, 15, 0, 5), -1, -1));
        importWayPanel.add(importFromWxCpPanel, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        importFromWxCpPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "通过企业通讯录导入", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, this.$$$getFont$$$(null, Font.BOLD, -1, importFromWxCpPanel.getFont()), null));
        wxCpTagsComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        wxCpTagsComboBox.setModel(defaultComboBoxModel2);
        importFromWxCpPanel.add(wxCpTagsComboBox, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        wxCpDeptsComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel3 = new DefaultComboBoxModel();
        wxCpDeptsComboBox.setModel(defaultComboBoxModel3);
        importFromWxCpPanel.add(wxCpDeptsComboBox, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        wxCpImportAllButton = new JButton();
        Font wxCpImportAllButtonFont = this.$$$getFont$$$(null, Font.PLAIN, -1, wxCpImportAllButton.getFont());
        if (wxCpImportAllButtonFont != null) wxCpImportAllButton.setFont(wxCpImportAllButtonFont);
        wxCpImportAllButton.setIcon(new ImageIcon(getClass().getResource("/icon/import_dark.png")));
        wxCpImportAllButton.setText("导入通讯录中所有用户");
        importFromWxCpPanel.add(wxCpImportAllButton, new GridConstraints(2, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        wxCpTagsRefreshButton = new JButton();
        Font wxCpTagsRefreshButtonFont = this.$$$getFont$$$(null, Font.PLAIN, -1, wxCpTagsRefreshButton.getFont());
        if (wxCpTagsRefreshButtonFont != null) wxCpTagsRefreshButton.setFont(wxCpTagsRefreshButtonFont);
        wxCpTagsRefreshButton.setIcon(new ImageIcon(getClass().getResource("/icon/refresh.png")));
        wxCpTagsRefreshButton.setText("刷新");
        importFromWxCpPanel.add(wxCpTagsRefreshButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, 1, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        wxCpDeptsRefreshButton = new JButton();
        Font wxCpDeptsRefreshButtonFont = this.$$$getFont$$$(null, Font.PLAIN, -1, wxCpDeptsRefreshButton.getFont());
        if (wxCpDeptsRefreshButtonFont != null) wxCpDeptsRefreshButton.setFont(wxCpDeptsRefreshButtonFont);
        wxCpDeptsRefreshButton.setIcon(new ImageIcon(getClass().getResource("/icon/refresh.png")));
        wxCpDeptsRefreshButton.setText("刷新");
        importFromWxCpPanel.add(wxCpDeptsRefreshButton, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, 1, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("按标签导入");
        importFromWxCpPanel.add(label3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("按部门导入");
        importFromWxCpPanel.add(label4, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        wxCpTagsImportButton = new JButton();
        wxCpTagsImportButton.setIcon(new ImageIcon(getClass().getResource("/icon/import_dark.png")));
        wxCpTagsImportButton.setText("导入");
        importFromWxCpPanel.add(wxCpTagsImportButton, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        wxCpDeptsImportButton = new JButton();
        wxCpDeptsImportButton.setIcon(new ImageIcon(getClass().getResource("/icon/import_dark.png")));
        wxCpDeptsImportButton.setText("导入");
        importFromWxCpPanel.add(wxCpDeptsImportButton, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        importFromDingPanel = new JPanel();
        importFromDingPanel.setLayout(new GridLayoutManager(2, 4, new Insets(8, 15, 0, 5), -1, -1));
        importWayPanel.add(importFromDingPanel, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        importFromDingPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "通过钉钉通讯录导入", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, this.$$$getFont$$$(null, Font.BOLD, -1, importFromDingPanel.getFont()), null));
        dingDeptsComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel4 = new DefaultComboBoxModel();
        dingDeptsComboBox.setModel(defaultComboBoxModel4);
        importFromDingPanel.add(dingDeptsComboBox, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        dingImportAllButton = new JButton();
        Font dingImportAllButtonFont = this.$$$getFont$$$(null, Font.PLAIN, -1, dingImportAllButton.getFont());
        if (dingImportAllButtonFont != null) dingImportAllButton.setFont(dingImportAllButtonFont);
        dingImportAllButton.setIcon(new ImageIcon(getClass().getResource("/icon/import_dark.png")));
        dingImportAllButton.setText("导入通讯录中所有用户");
        importFromDingPanel.add(dingImportAllButton, new GridConstraints(1, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        dingDeptsRefreshButton = new JButton();
        Font dingDeptsRefreshButtonFont = this.$$$getFont$$$(null, Font.PLAIN, -1, dingDeptsRefreshButton.getFont());
        if (dingDeptsRefreshButtonFont != null) dingDeptsRefreshButton.setFont(dingDeptsRefreshButtonFont);
        dingDeptsRefreshButton.setIcon(new ImageIcon(getClass().getResource("/icon/refresh.png")));
        dingDeptsRefreshButton.setText("刷新");
        importFromDingPanel.add(dingDeptsRefreshButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, 1, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("按部门导入");
        importFromDingPanel.add(label5, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        dingDeptsImportButton = new JButton();
        dingDeptsImportButton.setIcon(new ImageIcon(getClass().getResource("/icon/import_dark.png")));
        dingDeptsImportButton.setText("导入");
        importFromDingPanel.add(dingDeptsImportButton, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        importOptionPanel = new JPanel();
        importOptionPanel.setLayout(new GridLayoutManager(1, 5, new Insets(0, 15, 0, 0), -1, -1));
        importWayPanel.add(importOptionPanel, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        importOptionPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-276358)), "导入选项", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, this.$$$getFont$$$(null, Font.BOLD, -1, importOptionPanel.getFont()), new Color(-276358)));
        importOptionOpenIdCheckBox = new JCheckBox();
        importOptionOpenIdCheckBox.setEnabled(false);
        importOptionOpenIdCheckBox.setSelected(true);
        importOptionOpenIdCheckBox.setText("openId");
        importOptionPanel.add(importOptionOpenIdCheckBox, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        importOptionPanel.add(spacer3, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        importOptionBasicInfoCheckBox = new JCheckBox();
        importOptionBasicInfoCheckBox.setText("昵称、性别等基本信息");
        importOptionBasicInfoCheckBox.setToolTipText("每获取一条信息会花费一次每日接口调用量");
        importOptionPanel.add(importOptionBasicInfoCheckBox, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        importOptionAvatarCheckBox = new JCheckBox();
        importOptionAvatarCheckBox.setText("头像");
        importOptionAvatarCheckBox.setToolTipText("勾选会导致左侧列表甚至WePush变卡哦");
        importOptionPanel.add(importOptionAvatarCheckBox, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        clearDbCacheButton = new JButton();
        clearDbCacheButton.setText("清空本地缓存");
        importOptionPanel.add(clearDbCacheButton, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        importFromNumPanel = new JPanel();
        importFromNumPanel.setLayout(new GridLayoutManager(1, 3, new Insets(8, 15, 0, 5), -1, -1));
        importWayPanel.add(importFromNumPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        importFromNumPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), "没有变量，直接按数量发送", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, this.$$$getFont$$$(null, Font.BOLD, -1, importFromNumPanel.getFont()), null));
        数量Label = new JLabel();
        数量Label.setHorizontalAlignment(11);
        数量Label.setHorizontalTextPosition(4);
        数量Label.setText("数量");
        importFromNumPanel.add(数量Label, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        importNumTextField = new JTextField();
        importFromNumPanel.add(importNumTextField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        importFromNumButton = new JButton();
        importFromNumButton.setIcon(new ImageIcon(getClass().getResource("/icon/import_dark.png")));
        importFromNumButton.setText("导入");
        importFromNumPanel.add(importFromNumButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return memberPanel;
    }

}
