package com.view;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.entity.UserInfo;
import com.entity.Street;
import com.entity.Dshop;
import com.entity.ShopSafe;
import com.entity.Person;
import com.service.DshopService;
import com.service.PersonService;
import com.service.ShopSafeService;
import com.service.StreetService;
import com.service.UserInfoService;
import com.service.impl.DshopServiceImpl;
import com.service.impl.PersonServiceImpl;
import com.service.impl.ShopSafeServiceImpl;
import com.service.impl.StreetServiceImpl;
import com.service.impl.UserInfoServiceImpl;

public class MainUI {
	
	private static UserInfoService userInfoService=new UserInfoServiceImpl();
	private static StreetService streetService=new StreetServiceImpl();
	private static DshopService dshopService=new DshopServiceImpl();
	private static ShopSafeService shopSafeService=new ShopSafeServiceImpl();
	private static PersonService personService=new PersonServiceImpl();
	private static int index=0;
	
	public static void main(String[] args) {
		MainUI.UserLogin();
	}
	
	/**
	 * 用户登录页面
	 */
	public static void UserLogin(){
		final JFrame frame=new JFrame();
		frame.setSize(360,400);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-440)/2,
				(Toolkit.getDefaultToolkit().getScreenSize().height-500)/2);
		frame.setTitle("系统登录");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel jLabel_title=new JLabel("系统登录");
		jLabel_title.setFont(new Font("Dialog", 1, 20));
		frame.add(jLabel_title);
		jLabel_title.setBounds(130, 20, 100, 40);
		
		JLabel jLabel_username=new JLabel("用户名:");
		JTextField jTextField_username=new JTextField();
		frame.add(jLabel_username);
		frame.add(jTextField_username);
		jLabel_username.setBounds(30, 80, 50, 30);		
		jTextField_username.setBounds(100, 80, 200, 30);
		jTextField_username.setColumns(8);
		
		JLabel jLabel_password=new JLabel("密    码:");
		JPasswordField jPasswordField_password=new JPasswordField();
		frame.add(jLabel_password);
		frame.add(jPasswordField_password);
		jLabel_password.setBounds(30, 140, 50, 30);
		jPasswordField_password.setBounds(100, 140, 200, 30);
		jPasswordField_password.setColumns(8);
		
		JButton jButton_regist=new JButton("用户注册");
		frame.add(jButton_regist);
		jButton_regist.setBounds(130, 200, 100, 30);
		jButton_regist.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				MainUI.UserRegist();
			}
		});
		
		JButton jButton_login=new JButton("登录");
		frame.add(jButton_login);
		jButton_login.setBounds(60, 250, 60, 30);
		jButton_login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UserInfo userInfo=new UserInfo();
				String username=jTextField_username.getText().trim();
				String password=new String(jPasswordField_password.getPassword()).trim();
				userInfo.setPassword(password);
				userInfo.setUsername(username);
				userInfo=userInfoService.userLogin(userInfo);
				
				if(userInfo.getUsername()!=null){
					frame.dispose();
					//打开主界面
					MainUI.Menu();
				}else{
					JOptionPane.showConfirmDialog(frame, 
							"用户名密码不匹配！", "Message",JOptionPane.ERROR_MESSAGE);
					jTextField_username.setText("");
					jPasswordField_password.setText("");
				}
			}
		});
		
		JButton jButton_reset=new JButton("重置");
		frame.add(jButton_reset);
		jButton_reset.setBounds(240, 250, 60, 30);
		jButton_reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jTextField_username.setText("");
				jPasswordField_password.setText("");
			}
		});
	}
	
	/**
	 * 用户注册页面
	 */
	public static void UserRegist(){
		final JFrame frame=new JFrame();
		frame.setSize(360,400);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-440)/2,
				(Toolkit.getDefaultToolkit().getScreenSize().height-500)/2);
		frame.setTitle("用户注册");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel jLabel_title=new JLabel("用户注册");
		jLabel_title.setFont(new Font("Dialog", 1, 20));
		frame.add(jLabel_title);
		jLabel_title.setBounds(130, 20, 100, 40);
		
		JLabel jLabel_username=new JLabel("用  户  名:");
		JTextField jTextField_username=new JTextField();
		frame.add(jLabel_username);
		frame.add(jTextField_username);
		jLabel_username.setBounds(20, 80, 60, 30);		
		jTextField_username.setBounds(100, 80, 200, 30);
		jTextField_username.setColumns(8);
		
		JLabel jLabel_password=new JLabel("登录密码:");
		JPasswordField jPasswordField_password=new JPasswordField();
		frame.add(jLabel_password);
		frame.add(jPasswordField_password);
		jLabel_password.setBounds(20, 140, 60, 30);
		jPasswordField_password.setBounds(100, 140, 200, 30);
		jPasswordField_password.setColumns(8);
		
		JLabel jLabel_repassword=new JLabel("确认密码:");
		JPasswordField jPasswordField_repassword=new JPasswordField();
		frame.add(jLabel_repassword);
		frame.add(jPasswordField_repassword);
		jLabel_repassword.setBounds(20, 200, 60, 30);
		jPasswordField_repassword.setBounds(100, 200, 200, 30);
		jPasswordField_repassword.setColumns(8);
		
		JButton jButton_regist=new JButton("注册");
		frame.add(jButton_regist);
		jButton_regist.setBounds(60, 250, 60, 30);
		jButton_regist.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String message="注册成功！";
				Boolean bool=true;
				String username=jTextField_username.getText().trim();
				if(username.length()<6){
					message="用户名需大于6位";
					bool=false;
				}
				String password=new String(jPasswordField_password.getPassword()).trim();
				if(password.length()<8&&bool){
					message="密码需大于8位";
					bool=false;
				}
				String repassword=new String(jPasswordField_repassword.getPassword()).trim();
				if(!repassword.equals(password)&&bool){
					message="两次密码不一致";
					bool=false;
				}
				if(bool){
					UserInfo userInfo=new UserInfo();
					userInfo.setPassword(repassword);
					userInfo.setUsername(username);
					int count=userInfoService.userRegist(userInfo);
					if(count>0){
						message="注册成功！";
						JOptionPane.showConfirmDialog(frame, 
								message, "Message",JOptionPane.ERROR_MESSAGE);
						frame.dispose();
						MainUI.UserLogin();
					}else{
						message="注册失败！";
						JOptionPane.showConfirmDialog(frame, 
								message, "Message",JOptionPane.ERROR_MESSAGE);
						jTextField_username.setText("");
						jPasswordField_password.setText("");
						jPasswordField_repassword.setText("");
					}
				}else{
					JOptionPane.showConfirmDialog(frame, 
							message, "Message",JOptionPane.ERROR_MESSAGE);
					jTextField_username.setText("");
					jPasswordField_password.setText("");
					jPasswordField_repassword.setText("");
				}
			}
		});
		
		JButton jButton_cancel=new JButton("取消");
		frame.add(jButton_cancel);
		jButton_cancel.setBounds(240, 250, 60, 30);
		jButton_cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainUI.UserLogin();
			}
		});
	}
	
	/**
	 * 菜单页面
	 */
	public static void Menu(){
		final JFrame frame=new JFrame();
		frame.setSize(360,400);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-440)/2,
				(Toolkit.getDefaultToolkit().getScreenSize().height-500)/2);
		frame.setTitle("街道店铺安全管理系统");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel jLabel_title=new JLabel("欢迎您使用本系统");
		jLabel_title.setFont(new Font("Dialog", 1, 20));
		frame.add(jLabel_title);
		jLabel_title.setBounds(90, 20, 180, 40);
		
		JButton jButton_street=new JButton("街道管理");
		frame.add(jButton_street);
		jButton_street.setBounds(110, 120, 140, 40);
		jButton_street.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainUI.Street(0);
			}
		});
		
		JButton jButton_dshop=new JButton("店铺管理");
		frame.add(jButton_dshop);
		jButton_dshop.setBounds(110, 180, 140, 40);
		jButton_dshop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainUI.Dshop(0);
			}
		});
		
		JButton jButton_shopsafe=new JButton("安全等级管理");
		frame.add(jButton_shopsafe);
		jButton_shopsafe.setBounds(110, 240, 140, 40);
		jButton_shopsafe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainUI.ShopSafe(0);
			}
		});
		
		JButton jButton_person=new JButton("安全负责人管理");
		frame.add(jButton_person);
		jButton_person.setBounds(110, 300, 140, 40);
		jButton_person.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainUI.Person(0);
			}
		});
	}
	
	/**
	 * 街道管理
	 * @param num
	 */
	public static void Street(int num){
		ArrayList<Street> streets=streetService.getAllStreet();
		index=num;
		final JFrame frame=new JFrame();
		frame.setSize(380,580);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-440)/2,
				(Toolkit.getDefaultToolkit().getScreenSize().height-500)/2);
		frame.setTitle("街道管理");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel jLabel_title=new JLabel("街道管理");
		jLabel_title.setFont(new Font("Dialog", 1, 20));
		frame.add(jLabel_title);
		jLabel_title.setBounds(130, 20, 100, 40);
		//添加信息--begin
		JLabel jLabel_add_sno=new JLabel("编号:");
		JTextField jTextField_add_sno=new JTextField();
		JLabel jLabel_add_sname=new JLabel("名称:");
		JTextField jTextField_add_sname=new JTextField();
		JLabel jLabel_add_mname=new JLabel("管理员:");
		JTextField jTextField_add_mname=new JTextField();
		JLabel jLabel_add_mtel=new JLabel("联系电话:");
		JTextField jTextField_add_mtel=new JTextField();
		
		frame.add(jLabel_add_sno);
		frame.add(jTextField_add_sno);
		frame.add(jLabel_add_sname);
		frame.add(jTextField_add_sname);
		frame.add(jLabel_add_mname);
		frame.add(jTextField_add_mname);
		frame.add(jLabel_add_mtel);
		frame.add(jTextField_add_mtel);
		jLabel_add_sno.setBounds(30, 80, 60, 24);		
		jTextField_add_sno.setBounds(100, 80, 200, 24);
		jTextField_add_sno.setColumns(8);
		
		jLabel_add_sname.setBounds(30, 120, 60, 24);
		jTextField_add_sname.setBounds(100, 120, 200, 24);
		jTextField_add_sname.setColumns(8);
		
		jLabel_add_mname.setBounds(30, 160, 60, 24);		
		jTextField_add_mname.setBounds(100, 160, 200, 24);
		jTextField_add_mname.setColumns(8);
		
		jLabel_add_mtel.setBounds(30, 200, 60, 24);
		jTextField_add_mtel.setBounds(100, 200, 200, 24);
		jTextField_add_mtel.setColumns(8);
		
		JButton jButton_add=new JButton("添加信息");
		frame.add(jButton_add);
		jButton_add.setBounds(140, 240, 100, 24);
		jButton_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Street street=new Street();
				String sno=jTextField_add_sno.getText().trim();
				String sname=jTextField_add_sname.getText().trim();
				String mname=jTextField_add_mname.getText().trim();
				String mtel=jTextField_add_mtel.getText().trim();
				street.setMname(mname);
				street.setMtel(mtel);
				street.setSname(sname);
				street.setSno(sno);
				
				int count=streetService.addStreet(street);
				if(count<1){
					JOptionPane.showMessageDialog(frame,"添加失败！");
				}else{
					jTextField_add_sno.setText("");
					jTextField_add_sname.setText("");
					jTextField_add_mname.setText("");
					jTextField_add_mtel.setText("");
					JOptionPane.showMessageDialog(frame,"添加成功");
					frame.dispose();
					MainUI.Street(index);
				}
				
			}
		});
		//添加结束
		
		//信息展示
		JLabel jLabel_sno=new JLabel("标号:"+streets.get(index).getSno());
		JLabel jLabel_sname=new JLabel("名称:"+streets.get(index).getSname());
		JLabel jLabel_mname=new JLabel("负责人:"+streets.get(index).getMname());
		JLabel jLabel_mtel=new JLabel("电话:"+streets.get(index).getMtel());
		
		frame.add(jLabel_sno);
		frame.add(jLabel_sname);
		frame.add(jLabel_mname);
		frame.add(jLabel_mtel);
		
		jLabel_sno.setBounds(40, 280, 120, 24);
		jLabel_sname.setBounds(40, 320, 120, 24);
		jLabel_mname.setBounds(40, 360, 120, 24);
		jLabel_mtel.setBounds(40, 400, 120, 24);
		//信息展示结束
		
		//修改开始
		JTextField jTextField_edit_sname=new JTextField();
		JTextField jTextField_edit_mname=new JTextField();
		JTextField jTextField_edit_mtel=new JTextField();
		frame.add(jTextField_edit_sname);
		frame.add(jTextField_edit_mname);
		frame.add(jTextField_edit_mtel);
		
		jTextField_edit_sname.setBounds(200, 320, 120, 24);
		jTextField_edit_mname.setBounds(200, 360, 120, 24);
		jTextField_edit_mtel.setBounds(200, 400, 120, 24);
		
		JButton jButton_update=new JButton("修改");
		frame.add(jButton_update);
		jButton_update.setBounds(280, 460, 80, 24);
		jButton_update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int choice=JOptionPane.showConfirmDialog(null,"是否修改？","提示",JOptionPane.YES_NO_OPTION);
				if(choice==1){
					jTextField_edit_sname.setText("");
					jTextField_edit_mname.setText("");
					jTextField_edit_mtel.setText("");
				}else{
					Street street=new Street();
					String sname=jTextField_edit_sname.getText().trim();
					String mname=jTextField_edit_mname.getText().trim();
					String mtel=jTextField_edit_mtel.getText().trim();
					street.setMname(mname);
					street.setMtel(mtel);
					street.setSname(sname);
					street.setSno(streets.get(index).getSno());
					
					int count=streetService.updateStreet(street);
					if(count>0){
						jTextField_edit_sname.setText("");
						jTextField_edit_mname.setText("");
						jTextField_edit_mtel.setText("");
						JOptionPane.showMessageDialog(frame,"修改成功");
						frame.dispose();
						MainUI.Street(index);
					}else{
						JOptionPane.showMessageDialog(frame,"修改失败");
					}
				}
			}
		});
		//修改结束
		
		//底部按钮
		JButton jButton_last=new JButton("上一条");
		frame.add(jButton_last);
		jButton_last.setBounds(10, 460, 80, 24);
		jButton_last.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(index==0){
					JOptionPane.showMessageDialog(frame,"这已经是第一条消息了");
				}else{
					index--;
					MainUI.Street(index);
					frame.dispose();
				}
				
			}
		});

		JButton jButton_next=new JButton("下一条");
		frame.add(jButton_next);
		jButton_next.setBounds(100, 460, 80, 24);
		jButton_next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(index==streets.size()-1){
					JOptionPane.showMessageDialog(frame,"这已经是最后一条消息了");
				}else{
					index++;
					MainUI.Street(index);
					frame.dispose();
				}
				
			}
		});
		JButton jButton_delete=new JButton("删除");
		frame.add(jButton_delete);
		jButton_delete.setBounds(190, 460, 80, 24);
		jButton_delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int type=JOptionPane.YES_NO_OPTION;
				int choice=JOptionPane.showConfirmDialog(null,"是否修改？","提示",type);
				if(choice==1){
					JOptionPane.showMessageDialog(frame,"删除取消");
				}else{
					int count=streetService.deleteStreet(streets.get(index).getSno());
					if(count>0){
						JOptionPane.showMessageDialog(frame,"删除成功");
						frame.dispose();
						MainUI.Street(0);
					}else{
						JOptionPane.showMessageDialog(frame,"删除失败");
					}
				}
			}
		});
		JButton jButton_back=new JButton("返回主菜单");
		frame.add(jButton_back);
		jButton_back.setBounds(140, 500, 100, 24);
		jButton_back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainUI.Menu();
			}
		});
	}
	
	/**
	 * 店铺管理
	 * @param num
	 */
	public static void Dshop(int num){
		ArrayList<Dshop> dshops=dshopService.getAllDshop();
		index=num;
		final JFrame frame=new JFrame();
		frame.setSize(380,660);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-440)/2,
				(Toolkit.getDefaultToolkit().getScreenSize().height-500)/2);
		frame.setTitle("店铺管理");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel jLabel_title=new JLabel("店铺管理");
		jLabel_title.setFont(new Font("Dialog", 1, 20));
		frame.add(jLabel_title);
		jLabel_title.setBounds(130, 20, 100, 40);
		//添加信息--begin
		JLabel jLabel_add_dno=new JLabel("编号:");
		JTextField jTextField_add_dno=new JTextField();
		JLabel jLabel_add_dname=new JLabel("名称:");
		JTextField jTextField_add_dname=new JTextField();
		JLabel jLabel_add_dtype=new JLabel("类型:");
		JTextField jTextField_add_dtype=new JTextField();
		JLabel jLabel_add_dtel=new JLabel("联系电话:");
		JTextField jTextField_add_dtel=new JTextField();
		JLabel jLabel_add_dsafe=new JLabel("安全等级:");
		JTextField jTextField_add_dsafe=new JTextField();
		
		frame.add(jLabel_add_dno);
		frame.add(jTextField_add_dno);
		frame.add(jLabel_add_dname);
		frame.add(jTextField_add_dname);
		frame.add(jLabel_add_dtype);
		frame.add(jTextField_add_dtype);
		frame.add(jLabel_add_dtel);
		frame.add(jTextField_add_dtel);
		frame.add(jLabel_add_dsafe);
		frame.add(jTextField_add_dsafe);
		jLabel_add_dno.setBounds(30, 80, 60, 24);		
		jTextField_add_dno.setBounds(100, 80, 200, 24);
		jTextField_add_dno.setColumns(8);
		
		jLabel_add_dname.setBounds(30, 120, 60, 24);
		jTextField_add_dname.setBounds(100, 120, 200, 24);
		jTextField_add_dname.setColumns(8);
		
		jLabel_add_dtype.setBounds(30, 160, 60, 24);		
		jTextField_add_dtype.setBounds(100, 160, 200, 24);
		jTextField_add_dtype.setColumns(8);
		
		jLabel_add_dtel.setBounds(30, 200, 60, 24);
		jTextField_add_dtel.setBounds(100, 200, 200, 24);
		jTextField_add_dtel.setColumns(8);
		
		jLabel_add_dsafe.setBounds(30, 240, 60, 24);
		jTextField_add_dsafe.setBounds(100, 240, 200, 24);
		jTextField_add_dsafe.setColumns(8);
		
		JButton jButton_add=new JButton("添加信息");
		frame.add(jButton_add);
		jButton_add.setBounds(140, 280, 100, 24);
		jButton_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Dshop dshop=new Dshop();
				String dno=jTextField_add_dno.getText().trim();
				String dname=jTextField_add_dname.getText().trim();
				String dtype=jTextField_add_dtype.getText().trim();
				String dtel=jTextField_add_dtel.getText().trim();
				String dsafe=jTextField_add_dsafe.getText().trim();
				dshop.setDname(dname);
				dshop.setDno(dno);
				dshop.setDsafe(dsafe);
				dshop.setDtel(dtel);
				dshop.setDtype(dtype);
				
				int count=dshopService.addDshop(dshop);
				if(count<1){
					JOptionPane.showMessageDialog(frame,"添加失败！");
				}else{
					jTextField_add_dno.setText("");
					jTextField_add_dname.setText("");
					jTextField_add_dtype.setText("");
					jTextField_add_dtel.setText("");
					jTextField_add_dsafe.setText("");
					JOptionPane.showMessageDialog(frame,"添加成功");
					frame.dispose();
					MainUI.Dshop(index);
				}
				
			}
		});
		//添加结束
		
		//信息展示
		JLabel jLabel_dno=new JLabel("标号:"+dshops.get(index).getDno());
		JLabel jLabel_dname=new JLabel("名称:"+dshops.get(index).getDname());
		JLabel jLabel_dtype=new JLabel("类型:"+dshops.get(index).getDtype());
		JLabel jLabel_dtel=new JLabel("电话:"+dshops.get(index).getDtel());
		JLabel jLabel_dsafe=new JLabel("安全等级:"+dshops.get(index).getDsafe());
		
		frame.add(jLabel_dno);
		frame.add(jLabel_dname);
		frame.add(jLabel_dtype);
		frame.add(jLabel_dtel);
		frame.add(jLabel_dsafe);
		
		jLabel_dno.setBounds(40, 320, 120, 24);
		jLabel_dname.setBounds(40, 360, 120, 24);
		jLabel_dtype.setBounds(40, 400, 120, 24);
		jLabel_dtel.setBounds(40, 440, 120, 24);
		jLabel_dsafe.setBounds(40, 480, 120, 24);
		//信息展示结束
		
		//修改开始
		JTextField jTextField_edit_dname=new JTextField();
		JTextField jTextField_edit_dtype=new JTextField();
		JTextField jTextField_edit_dtel=new JTextField();
		JTextField jTextField_edit_dsafe=new JTextField();
		frame.add(jTextField_edit_dname);
		frame.add(jTextField_edit_dtype);
		frame.add(jTextField_edit_dtel);
		frame.add(jTextField_edit_dsafe);
		
		jTextField_edit_dname.setBounds(200, 360, 120, 24);
		jTextField_edit_dtype.setBounds(200, 400, 120, 24);
		jTextField_edit_dtel.setBounds(200, 440, 120, 24);
		jTextField_edit_dsafe.setBounds(200, 480, 120, 24);
		
		JButton jButton_update=new JButton("修改");
		frame.add(jButton_update);
		jButton_update.setBounds(280, 540, 80, 24);
		jButton_update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int choice=JOptionPane.showConfirmDialog(null,"是否修改？","提示",JOptionPane.YES_NO_OPTION);
				if(choice==1){
					jTextField_edit_dname.setText("");
					jTextField_edit_dtype.setText("");
					jTextField_edit_dtel.setText("");
					jTextField_edit_dsafe.setText("");
				}else{
					Dshop dshop=new Dshop();
					String dname=jTextField_edit_dname.getText().trim();
					String dtype=jTextField_edit_dtype.getText().trim();
					String dtel=jTextField_edit_dtel.getText().trim();
					String dsafe=jTextField_edit_dsafe.getText().trim();
					dshop.setDname(dname);
					dshop.setDsafe(dsafe);
					dshop.setDtel(dtel);
					dshop.setDtype(dtype);
					dshop.setDno(dshops.get(index).getDno());
					
					int count=dshopService.updateDshop(dshop);
					if(count>0){
						jTextField_edit_dname.setText("");
						jTextField_edit_dtype.setText("");
						jTextField_edit_dtel.setText("");
						jTextField_edit_dsafe.setText("");
						JOptionPane.showMessageDialog(frame,"修改成功");
						frame.dispose();
						MainUI.Dshop(index);
					}else{
						JOptionPane.showMessageDialog(frame,"修改失败");
					}
				}
			}
		});
		//修改结束
		
		//底部按钮
		JButton jButton_last=new JButton("上一条");
		frame.add(jButton_last);
		jButton_last.setBounds(10, 540, 80, 24);
		jButton_last.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(index==0){
					JOptionPane.showMessageDialog(frame,"这已经是第一条消息了");
				}else{
					index--;
					MainUI.Dshop(index);
					frame.dispose();
				}
				
			}
		});

		JButton jButton_next=new JButton("下一条");
		frame.add(jButton_next);
		jButton_next.setBounds(100, 540, 80, 24);
		jButton_next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(index==dshops.size()-1){
					JOptionPane.showMessageDialog(frame,"这已经是最后一条消息了");
				}else{
					index++;
					MainUI.Dshop(index);
					frame.dispose();
				}
				
			}
		});
		JButton jButton_delete=new JButton("删除");
		frame.add(jButton_delete);
		jButton_delete.setBounds(190, 540, 80, 24);
		jButton_delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int type=JOptionPane.YES_NO_OPTION;
				int choice=JOptionPane.showConfirmDialog(null,"是否修改？","提示",type);
				if(choice==1){
					JOptionPane.showMessageDialog(frame,"删除取消");
				}else{
					int count=streetService.deleteStreet(dshops.get(index).getDno());
					if(count>0){
						JOptionPane.showMessageDialog(frame,"删除成功");
						frame.dispose();
						MainUI.Dshop(0);
					}else{
						JOptionPane.showMessageDialog(frame,"删除失败");
					}
				}
			}
		});
		JButton jButton_back=new JButton("返回主菜单");
		frame.add(jButton_back);
		jButton_back.setBounds(140, 580, 100, 24);
		jButton_back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainUI.Menu();
			}
		});
	}
	/**
	 * 安全等级管理
	 * @param num
	 */
	public static void ShopSafe(int num){
		ArrayList<ShopSafe> ShopSafes=shopSafeService.getAllShopSafe();
		index=num;
		final JFrame frame=new JFrame();
		frame.setSize(380,660);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-440)/2,
				(Toolkit.getDefaultToolkit().getScreenSize().height-500)/2);
		frame.setTitle("安全等级管理");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel jLabel_title=new JLabel("安全等级管理");
		jLabel_title.setFont(new Font("Dialog", 1, 20));
		frame.add(jLabel_title);
		jLabel_title.setBounds(130, 20, 100, 40);
		//添加信息--begin
		JLabel jLabel_add_dno=new JLabel("商家编号:");
		JTextField jTextField_add_dno=new JTextField();
		JLabel jLabel_add_sno=new JLabel("街道编号：");
		JTextField jTextField_add_sno=new JTextField();
		JLabel jLabel_add_xflevel=new JLabel("xflevel:");
		JTextField jTextField_add_xflevel=new JTextField();
		JLabel jLabel_add_fwlevel=new JLabel("fwlevel:");
		JTextField jTextField_add_fwlevel=new JTextField();
		JLabel jLabel_add_qtlevel=new JLabel("qtlevel:");
		JTextField jTextField_add_qtlevel=new JTextField();
		
		frame.add(jLabel_add_dno);
		frame.add(jTextField_add_dno);
		frame.add(jLabel_add_sno);
		frame.add(jTextField_add_sno);
		frame.add(jLabel_add_xflevel);
		frame.add(jTextField_add_xflevel);
		frame.add(jLabel_add_fwlevel);
		frame.add(jTextField_add_fwlevel);
		frame.add(jLabel_add_qtlevel);
		frame.add(jTextField_add_qtlevel);
		jLabel_add_dno.setBounds(30, 80, 60, 24);		
		jTextField_add_dno.setBounds(100, 80, 200, 24);
		jTextField_add_dno.setColumns(8);
		
		jLabel_add_sno.setBounds(30, 120, 60, 24);
		jTextField_add_sno.setBounds(100, 120, 200, 24);
		jTextField_add_sno.setColumns(8);
		
		jLabel_add_xflevel.setBounds(30, 160, 60, 24);		
		jTextField_add_xflevel.setBounds(100, 160, 200, 24);
		jTextField_add_xflevel.setColumns(8);
		
		jLabel_add_fwlevel.setBounds(30, 200, 60, 24);
		jTextField_add_fwlevel.setBounds(100, 200, 200, 24);
		jTextField_add_fwlevel.setColumns(8);
		
		jLabel_add_qtlevel.setBounds(30, 240, 60, 24);
		jTextField_add_qtlevel.setBounds(100, 240, 200, 24);
		jTextField_add_qtlevel.setColumns(8);
		
		JButton jButton_add=new JButton("添加信息");
		frame.add(jButton_add);
		jButton_add.setBounds(140, 280, 100, 24);
		jButton_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ShopSafe shopSafe=new ShopSafe();
				String dno=jTextField_add_dno.getText().trim();
				String sno=jTextField_add_sno.getText().trim();
				String xflevel=jTextField_add_xflevel.getText().trim();
				String fwlevel=jTextField_add_fwlevel.getText().trim();
				String qtlevel=jTextField_add_qtlevel.getText().trim();
				shopSafe.setDno(dno);
				shopSafe.setFwlevel(fwlevel);
				shopSafe.setQtlevel(qtlevel);
				shopSafe.setSno(sno);
				shopSafe.setXflevel(xflevel);
				
				int count=shopSafeService.addShopSafe(shopSafe);
				if(count<1){
					JOptionPane.showMessageDialog(frame,"添加失败！");
				}else{
					jTextField_add_dno.setText("");
					jTextField_add_sno.setText("");
					jTextField_add_xflevel.setText("");
					jTextField_add_fwlevel.setText("");
					jTextField_add_qtlevel.setText("");
					JOptionPane.showMessageDialog(frame,"添加成功");
					frame.dispose();
					MainUI.Dshop(index);
				}
				
			}
		});
		//添加结束
		
		//信息展示
		JLabel jLabel_dno=new JLabel("商店编号:"+ShopSafes.get(index).getDno());
		JLabel jLabel_sno=new JLabel("街道编号:"+ShopSafes.get(index).getSno());
		JLabel jLabel_xflevel=new JLabel("xflevel:"+ShopSafes.get(index).getXflevel());
		JLabel jLabel_fwlevel=new JLabel("fwlevel:"+ShopSafes.get(index).getFwlevel());
		JLabel jLabel_qtlevel=new JLabel("qtlevel:"+ShopSafes.get(index).getQtlevel());
		
		frame.add(jLabel_dno);
		frame.add(jLabel_sno);
		frame.add(jLabel_xflevel);
		frame.add(jLabel_fwlevel);
		frame.add(jLabel_qtlevel);
		
		jLabel_dno.setBounds(40, 320, 120, 24);
		jLabel_sno.setBounds(40, 360, 120, 24);
		jLabel_xflevel.setBounds(40, 400, 120, 24);
		jLabel_fwlevel.setBounds(40, 440, 120, 24);
		jLabel_qtlevel.setBounds(40, 480, 120, 24);
		//信息展示结束
		
		//修改开始
		JTextField jTextField_edit_xflevel=new JTextField();
		JTextField jTextField_edit_fwlevel=new JTextField();
		JTextField jTextField_edit_qtlevel=new JTextField();
		frame.add(jTextField_edit_xflevel);
		frame.add(jTextField_edit_fwlevel);
		frame.add(jTextField_edit_qtlevel);
		
		jTextField_edit_xflevel.setBounds(200, 400, 120, 24);
		jTextField_edit_fwlevel.setBounds(200, 440, 120, 24);
		jTextField_edit_qtlevel.setBounds(200, 480, 120, 24);
		
		JButton jButton_update=new JButton("修改");
		frame.add(jButton_update);
		jButton_update.setBounds(280, 540, 80, 24);
		jButton_update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int choice=JOptionPane.showConfirmDialog(null,"是否修改？","提示",JOptionPane.YES_NO_OPTION);
				if(choice==1){
					jTextField_edit_xflevel.setText("");
					jTextField_edit_fwlevel.setText("");
					jTextField_edit_qtlevel.setText("");
				}else{
					ShopSafe shopSafe=new ShopSafe();
					String xflevel=jTextField_edit_xflevel.getText().trim();
					String fwlevel=jTextField_edit_fwlevel.getText().trim();
					String qtlevel=jTextField_edit_qtlevel.getText().trim();
					shopSafe.setDno(ShopSafes.get(index).getDno());
					shopSafe.setFwlevel(fwlevel);
					shopSafe.setQtlevel(qtlevel);
					shopSafe.setSno(ShopSafes.get(index).getSno());
					shopSafe.setXflevel(xflevel);
					
					int count=shopSafeService.updateShopSafe(shopSafe);
					if(count>0){
						jTextField_edit_xflevel.setText("");
						jTextField_edit_fwlevel.setText("");
						jTextField_edit_qtlevel.setText("");
						JOptionPane.showMessageDialog(frame,"修改成功");
						frame.dispose();
						MainUI.Dshop(index);
					}else{
						JOptionPane.showMessageDialog(frame,"修改失败");
					}
				}
			}
		});
		//修改结束
		
		//底部按钮
		JButton jButton_last=new JButton("上一条");
		frame.add(jButton_last);
		jButton_last.setBounds(10, 540, 80, 24);
		jButton_last.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(index==0){
					JOptionPane.showMessageDialog(frame,"这已经是第一条消息了");
				}else{
					index--;
					MainUI.ShopSafe(index);
					frame.dispose();
				}
				
			}
		});

		JButton jButton_next=new JButton("下一条");
		frame.add(jButton_next);
		jButton_next.setBounds(100, 540, 80, 24);
		jButton_next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(index==ShopSafes.size()-1){
					JOptionPane.showMessageDialog(frame,"这已经是最后一条消息了");
				}else{
					index++;
					MainUI.ShopSafe(index);
					frame.dispose();
				}
				
			}
		});
		JButton jButton_delete=new JButton("删除");
		frame.add(jButton_delete);
		jButton_delete.setBounds(190, 540, 80, 24);
		jButton_delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int type=JOptionPane.YES_NO_OPTION;
				int choice=JOptionPane.showConfirmDialog(null,"是否修改？","提示",type);
				if(choice==1){
					JOptionPane.showMessageDialog(frame,"删除取消");
				}else{
					int count=shopSafeService.deleteShopSafe(ShopSafes.get(index).getSno(), ShopSafes.get(index).getDno());
					if(count>0){
						JOptionPane.showMessageDialog(frame,"删除成功");
						frame.dispose();
						MainUI.ShopSafe(0);
					}else{
						JOptionPane.showMessageDialog(frame,"删除失败");
					}
				}
			}
		});
		JButton jButton_back=new JButton("返回主菜单");
		frame.add(jButton_back);
		jButton_back.setBounds(140, 580, 100, 24);
		jButton_back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainUI.Menu();
			}
		});
	}
	
	public static void Person(int num){
		ArrayList<Person> persons=personService.getAllPerson();
		index=num;
		final JFrame frame=new JFrame();
		frame.setSize(380,660);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-440)/2,
				(Toolkit.getDefaultToolkit().getScreenSize().height-500)/2);
		frame.setTitle("安全人员管理");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel jLabel_title=new JLabel("安全人员管理");
		jLabel_title.setFont(new Font("Dialog", 1, 20));
		frame.add(jLabel_title);
		jLabel_title.setBounds(130, 20, 100, 40);
		//添加信息--begin
		JLabel jLabel_add_dno=new JLabel("商家编号:");
		JTextField jTextField_add_dno=new JTextField();
		JLabel jLabel_add_sno=new JLabel("街道编号：");
		JTextField jTextField_add_sno=new JTextField();
		JLabel jLabel_add_pname=new JLabel("名字:");
		JTextField jTextField_add_pname=new JTextField();
		JLabel jLabel_add_psex=new JLabel("性别:");
		JTextField jTextField_add_psex=new JTextField();
		JLabel jLabel_add_ptel=new JLabel("电话:");
		JTextField jTextField_add_ptel=new JTextField();
		
		frame.add(jLabel_add_dno);
		frame.add(jTextField_add_dno);
		frame.add(jLabel_add_sno);
		frame.add(jTextField_add_sno);
		frame.add(jLabel_add_pname);
		frame.add(jTextField_add_pname);
		frame.add(jLabel_add_psex);
		frame.add(jTextField_add_psex);
		frame.add(jLabel_add_ptel);
		frame.add(jTextField_add_ptel);
		jLabel_add_dno.setBounds(30, 80, 60, 24);		
		jTextField_add_dno.setBounds(100, 80, 200, 24);
		jTextField_add_dno.setColumns(8);
		
		jLabel_add_sno.setBounds(30, 120, 60, 24);
		jTextField_add_sno.setBounds(100, 120, 200, 24);
		jTextField_add_sno.setColumns(8);
		
		jLabel_add_pname.setBounds(30, 160, 60, 24);		
		jTextField_add_pname.setBounds(100, 160, 200, 24);
		jTextField_add_pname.setColumns(8);
		
		jLabel_add_psex.setBounds(30, 200, 60, 24);
		jTextField_add_psex.setBounds(100, 200, 200, 24);
		jTextField_add_psex.setColumns(8);
		
		jLabel_add_ptel.setBounds(30, 240, 60, 24);
		jTextField_add_ptel.setBounds(100, 240, 200, 24);
		jTextField_add_ptel.setColumns(8);
		
		JButton jButton_add=new JButton("添加信息");
		frame.add(jButton_add);
		jButton_add.setBounds(140, 280, 100, 24);
		jButton_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Person person=new Person();
				String dno=jTextField_add_dno.getText().trim();
				String sno=jTextField_add_sno.getText().trim();
				String pname=jTextField_add_pname.getText().trim();
				String psex=jTextField_add_psex.getText().trim();
				String ptel=jTextField_add_ptel.getText().trim();
				person.setDno(dno);
				person.setPname(pname);
				person.setPsex(psex);
				person.setSno(sno);
				person.setPtel(ptel);
				
				int count=personService.addPerson(person);
				if(count<1){
					JOptionPane.showMessageDialog(frame,"添加失败！");
				}else{
					jTextField_add_dno.setText("");
					jTextField_add_sno.setText("");
					jTextField_add_pname.setText("");
					jTextField_add_psex.setText("");
					jTextField_add_ptel.setText("");
					JOptionPane.showMessageDialog(frame,"添加成功");
					frame.dispose();
					MainUI.Dshop(index);
				}
				
			}
		});
		//添加结束
		
		//信息展示
		JLabel jLabel_dno=new JLabel("商店编号:"+persons.get(index).getDno());
		JLabel jLabel_sno=new JLabel("街道编号:"+persons.get(index).getSno());
		JLabel jLabel_pname=new JLabel("姓名:"+persons.get(index).getPname());
		JLabel jLabel_psex=new JLabel("性别:"+persons.get(index).getPsex());
		JLabel jLabel_ptel=new JLabel("电话:"+persons.get(index).getPtel());
		JLabel jLabel_ptime=new JLabel("次数:"+persons.get(index).getPtime());
		
		frame.add(jLabel_dno);
		frame.add(jLabel_sno);
		frame.add(jLabel_pname);
		frame.add(jLabel_psex);
		frame.add(jLabel_ptel);
		frame.add(jLabel_ptime);
		
		jLabel_dno.setBounds(40, 320, 120, 24);
		jLabel_sno.setBounds(40, 360, 120, 24);
		jLabel_pname.setBounds(40, 400, 120, 24);
		jLabel_psex.setBounds(40, 440, 120, 24);
		jLabel_ptel.setBounds(40, 480, 120, 24);
		jLabel_ptime.setBounds(40, 520, 120, 24);
		//信息展示结束
		
		//修改开始
		JTextField jTextField_edit_pname=new JTextField();
		JTextField jTextField_edit_psex=new JTextField();
		JTextField jTextField_edit_ptel=new JTextField();
		JTextField jTextField_edit_ptime=new JTextField();
		frame.add(jTextField_edit_pname);
		frame.add(jTextField_edit_psex);
		frame.add(jTextField_edit_ptel);
		frame.add(jTextField_edit_ptime);
		
		jTextField_edit_pname.setBounds(200, 400, 120, 24);
		jTextField_edit_psex.setBounds(200, 440, 120, 24);
		jTextField_edit_ptel.setBounds(200, 480, 120, 24);
		jTextField_edit_ptime.setBounds(200, 520, 120, 24);
		
		JButton jButton_update=new JButton("修改");
		frame.add(jButton_update);
		jButton_update.setBounds(280, 580, 80, 24);
		jButton_update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int choice=JOptionPane.showConfirmDialog(null,"是否修改？","提示",JOptionPane.YES_NO_OPTION);
				if(choice==1){
					jTextField_edit_pname.setText("");
					jTextField_edit_psex.setText("");
					jTextField_edit_ptel.setText("");
					jTextField_edit_ptime.setText("");
				}else{
					Person person=new Person();
					String pname=jTextField_edit_pname.getText().trim();
					String psex=jTextField_edit_psex.getText().trim();
					String ptel=jTextField_edit_ptel.getText().trim();
					String ptime=jTextField_edit_ptime.getText().trim();
					person.setDno(persons.get(index).getDno());
					person.setPname(pname);
					person.setPsex(psex);
					person.setSno(persons.get(index).getSno());
					person.setPtel(ptel);
					person.setPtime(Integer.parseInt(ptime));
					
					int count=personService.updatePerson(person);
					if(count>0){
						jTextField_edit_pname.setText("");
						jTextField_edit_psex.setText("");
						jTextField_edit_ptel.setText("");
						JOptionPane.showMessageDialog(frame,"修改成功");
						frame.dispose();
						MainUI.Dshop(index);
					}else{
						JOptionPane.showMessageDialog(frame,"修改失败");
					}
				}
			}
		});
		//修改结束
		
		//底部按钮
		JButton jButton_last=new JButton("上一条");
		frame.add(jButton_last);
		jButton_last.setBounds(10, 580, 80, 24);
		jButton_last.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(index==0){
					JOptionPane.showMessageDialog(frame,"这已经是第一条消息了");
				}else{
					index--;
					MainUI.Person(index);
					frame.dispose();
				}
				
			}
		});

		JButton jButton_next=new JButton("下一条");
		frame.add(jButton_next);
		jButton_next.setBounds(100, 580, 80, 24);
		jButton_next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(index==persons.size()-1){
					JOptionPane.showMessageDialog(frame,"这已经是最后一条消息了");
				}else{
					index++;
					MainUI.Person(index);
					frame.dispose();
				}
				
			}
		});
		JButton jButton_delete=new JButton("删除");
		frame.add(jButton_delete);
		jButton_delete.setBounds(190, 580, 80, 24);
		jButton_delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int type=JOptionPane.YES_NO_OPTION;
				int choice=JOptionPane.showConfirmDialog(null,"是否修改？","提示",type);
				if(choice==1){
					JOptionPane.showMessageDialog(frame,"删除取消");
				}else{
					int count=shopSafeService.deleteShopSafe(persons.get(index).getSno(), persons.get(index).getDno());
					if(count>0){
						JOptionPane.showMessageDialog(frame,"删除成功");
						frame.dispose();
						MainUI.Person(0);
					}else{
						JOptionPane.showMessageDialog(frame,"删除失败");
					}
				}
			}
		});
		JButton jButton_back=new JButton("返回主菜单");
		frame.add(jButton_back);
		jButton_back.setBounds(140, 620, 100, 24);
		jButton_back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainUI.Menu();
			}
		});
	}
}
