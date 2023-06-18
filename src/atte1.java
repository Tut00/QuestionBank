import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class atte1 extends Application {
	Stage window;
	Scene Sc2;
	Scene Sc3;
	Scene Sc4;
	Scene Sc5;
	Scene Sc6;
	ComboBox<String> quis = new ComboBox<>();
	static BufferedReader file;
	String s1;
	String s2;
	String s3;
	String s4;
	static TextField A;
	static TextField B;
	static TextField C;
	static TextField D;
	RadioButton A1;
	RadioButton B1;
	RadioButton C1;
	RadioButton D1;
	static TextField tf;
	String c_q;
	String v_i;
	ArrayList<String> Q = new ArrayList<String>();
	ComboBox<String> is;
	ComboBox<String> es;
	public void start(Stage primaryStage) throws FileNotFoundException, IOException, Exception {
		window = primaryStage;
		BorderPane pane = new BorderPane();
		Text text = new Text("Click a button");
		text.setStyle("-fx-font: 20 arial;");
		Button creat = new Button("Creat");
		creat.setOnAction(e -> window.setScene(Sc2));
		Button view = new Button("View");
		view.setOnAction(e -> {
			quis.getItems().clear();
			window.setScene(Sc3);

			viewmeth(quis);

		});

		Button edit = new Button("Edit");
		edit.setOnAction(e -> {
			is.getItems().clear();
			window.setScene(Sc4);
			viewmeth(is);
		});
		Button delete = new Button("delete");
		delete.setOnAction(e -> {
			es.getItems().clear();
			window.setScene(Sc6);
			viewmeth(es);
		});
		HBox paneForButton = new HBox(20);
		paneForButton.setPadding(new Insets(5, 5, 5, 5));
		paneForButton.setAlignment(Pos.BOTTOM_CENTER);
		paneForButton.getChildren().addAll(view, creat, edit, delete);
		pane.setCenter(text);
		pane.setBottom(paneForButton);
		Scene Sc1 = new Scene(pane, 500, 500);
		///////////////////////////////////////////
		Button creat1 = new Button("Creat");
		Button back = new Button("Back");
		back.setOnAction(e -> window.setScene(Sc1));
		Label lab1 = new Label("Question");
		HBox paneForButton2 = new HBox(20);
		paneForButton2.setPadding(new Insets(5, 5, 5, 5));
		paneForButton2.getChildren().addAll(creat1, back);
		tf = new TextField();
		tf.setPromptText("Write your Question here");
		Label ans = new Label("Answers");
		A = new TextField();
		A.setPromptText("Write 1st answer(The correct answer)");

		B = new TextField();
		B.setPromptText("Write 2nd answer");

		C = new TextField();
		C.setPromptText("Write 3rd answer");

		D = new TextField();
		D.setPromptText("Write 4th answer");

		VBox v = new VBox(20);
		v.setPadding(new Insets(5, 5, 5, 5));
		v.getChildren().addAll(lab1, tf, ans, A, B, C, D);
		BorderPane pane2 = new BorderPane();
		pane2.setCenter(v);
		pane2.setBottom(paneForButton2);
		Sc2 = new Scene(pane2, 500, 500);
////////////////////////////////////////////////////////
		Button back2 = new Button("Back");

		HBox h = new HBox(20);
		h.setPadding(new Insets(30));
		ToggleGroup t = new ToggleGroup();
		A1 = new RadioButton();
		B1 = new RadioButton();
		C1 = new RadioButton();
		D1 = new RadioButton();
		A1.setToggleGroup(t);
		B1.setToggleGroup(t);
		C1.setToggleGroup(t);
		D1.setToggleGroup(t);
		VBox zx = new VBox(20);
		zx.setPadding(new Insets(5, 5, 5, 5));
		zx.getChildren().addAll(A1, B1, C1, D1);
		viewmeth(quis);
		h.getChildren().add(quis);
		HBox h2 = new HBox(20);
		h2.setPadding(new Insets(5, 5, 5, 5));
		Button Show = new Button("Show");
		Show.setOnAction(e -> {
			try {
				t.selectToggle(null);
				A1.setStyle("-fx-text-fill: black;");
				setanswer(quis, A1, B1, C1, D1);
				System.out.println(c_q);
			} catch (Exception e1) {
			}

		});
		back2.setOnAction(e -> {
			quis.getItems().clear();
			window.setScene(Sc1);
			t.selectToggle(null);
			A1.setStyle("-fx-text-fill: black;");
		});
		A1.setOnAction(e -> setColor());
		h2.getChildren().addAll(back2, Show);
		BorderPane pane3 = new BorderPane();
		pane3.setTop(h);
		pane3.setCenter(zx);
		pane3.setBottom(h2);
		Sc3 = new Scene(pane3, 500, 500);

		creat1.setOnAction(e -> {
			try {
				creatmeth();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
/////////////////////////////////////////////////////////////////
		Button edit1 = new Button("Edit");
		Button back3 = new Button("Back");
		Button show1 = new Button("Show");
		RadioButton _A1 = new RadioButton();
		RadioButton _B1 = new RadioButton();
		RadioButton _C1 = new RadioButton();
		RadioButton _D1 = new RadioButton();
		ToggleGroup t1 = new ToggleGroup();
		_A1.setToggleGroup(t1);
		_B1.setToggleGroup(t1);
		_C1.setToggleGroup(t1);
		_D1.setToggleGroup(t1);
		is = new ComboBox<>();
		viewmeth(is);
		HBox comboh = new HBox(20);
		comboh.setPadding(new Insets(30));
		comboh.getChildren().addAll(is);
		back3.setOnAction(e -> {
			window.setScene(Sc1);
			t.selectToggle(null);
		});
		show1.setOnAction(e -> {
			try {
				t.selectToggle(null);
				setanswer(is, _A1, _B1, _C1, _D1);
			} catch (Exception e1) {
			}
		});
		HBox edib = new HBox(20);
		edib.setPadding(new Insets(5, 5, 5, 5));
		edib.getChildren().addAll(edit1, back3, show1);
		VBox checkb = new VBox(20);
		checkb.setPadding(new Insets(5, 5, 5, 5));
		checkb.getChildren().addAll(_A1, _B1, _C1, _D1);
		BorderPane pane4 = new BorderPane();
		pane4.setTop(comboh);
		pane4.setCenter(checkb);
		pane4.setBottom(edib);
		Sc4 = new Scene(pane4, 500, 500);
		/////////////////////////////////

		TextField tx = new TextField();
		TextField tx1 = new TextField();
		TextField tx2 = new TextField();
		TextField tx3 = new TextField();
		TextField tx4 = new TextField();

		VBox nv = new VBox(20);
		nv.setPadding(new Insets(5, 5, 5, 5));
		nv.getChildren().addAll(tx, tx1, tx2, tx3, tx4);
		Button apply = new Button("Apply");
		Button back4 = new Button("Back");
		HBox xc = new HBox(40);
		xc.setPadding(new Insets(10, 10, 10, 10));
		xc.getChildren().addAll(apply, back4);
		back4.setOnAction(e -> {
			window.setScene(Sc1);
			t1.selectToggle(null);
		});
		BorderPane pane5 = new BorderPane();
		c_q = is.getSelectionModel().getSelectedItem();
		pane5.setCenter(nv);
		pane5.setBottom(xc);
		// pane5.setTop(co);
		Sc5 = new Scene(pane5, 500, 500);
		edit1.setOnAction(e -> {
			window.setScene(Sc5);
			try {
				setanswer(is, _A1, _B1, _C1, _D1);
				editmeth(tx, tx1, tx2, tx3, tx4, is);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});
		apply.setOnAction(e -> {
			Object[] po = Q.toArray();
			int count = 0;
			for (int i = 0; i < po.length; i++) {
				Object R = po[i];
				if (R.equals(c_q))
					break;
				else
					count++;
			}
			int we = count;
			Q.remove(we);
			Q.remove(we);
			Q.remove(we);
			Q.remove(we);
			Q.remove(we);
			Object[] u = new Object[] { tx.getText(), tx1.getText(), tx2.getText(), tx3.getText(), tx4.getText() };

			for (int r = 0; r < u.length; r++) {
				Q.add(u[r] + "");
			}

			System.out.println(Q);
			File file = new File("QuestionBank.dat");
			if (file.exists())
				file.delete();
			else
				try {
					file.createNewFile();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();

				}
			Object[] c = Q.toArray();
			try {
				BufferedOutputStream b = new BufferedOutputStream(new FileOutputStream("QuestionBank.dat", false));

				for (int i = 0; i < c.length; i++) {
					String pnm = " " + c[i] + "\n";
					byte[] oi = pnm.getBytes();
					b.write(oi);
				}
				b.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			viewmeth(is);
		});
////////////////////////////////////////////////////////////
		Button back5 = new Button("Back");
		Button delete1 = new Button("Delete");
		es = new ComboBox<>();
		viewmeth(es);
		HBox comboh1 = new HBox(20);
		comboh1.setPadding(new Insets(30));
		comboh1.getChildren().addAll(es);
		back5.setOnAction(e -> {
			window.setScene(Sc1);
			t.selectToggle(null);
		});
		HBox edib1 = new HBox(20);
		edib1.setAlignment(Pos.BOTTOM_CENTER);
		edib1.setPadding(new Insets(5, 5, 5, 5));
		edib1.getChildren().addAll(back5, delete1);
		delete1.setOnAction(e -> deletemeth());
		BorderPane pane6 = new BorderPane();
		pane6.setCenter(comboh1);
		pane6.setBottom(edib1);
		Sc6 = new Scene(pane6, 500, 500);

		window.setScene(Sc1);
		window.setTitle("Question Bank Creator");
		window.setScene(Sc1);
		window.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	void creatmeth() throws Exception {
		write(true);
		tf.clear();
		A.clear();
		B.clear();
		C.clear();
		D.clear();

	}

	void viewmeth(ComboBox<String> qu) {
		qu.getItems().clear();
		try {
			file = new BufferedReader(new FileReader("QuestionBank.dat"));

			while (file.read() != -1) {

				String g = new String(file.readLine());

				if (Q.contains(g))
					continue;
				else
					Q.add(g);
//				 i++;
			}
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {
			file.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

		Object[] c = Q.toArray();
		qu.getItems().clear();
		ArrayList<String> ss = new ArrayList<String>();
		for (int i = 0; i < c.length; i++) {

			if (i % 5 == 0) {
				if (ss.contains(c[i] + ""))
					continue;
				else
					ss.add(c[i] + "");
			} else
				continue;

		}
		qu.getItems().clear();
		qu.getItems().addAll(ss);

	}

	void write(boolean t) throws Exception {
		System.out.println(tf.getText());
		String s = (" " + tf.getText() + "\n");
		String s1 = " " + A.getText() + "\n";
		String s2 = " " + B.getText() + "\n";
		String s3 = " " + C.getText() + "\n";
		String s4 = " " + D.getText() + "\n";
		System.out.println(s);
		BufferedOutputStream b = new BufferedOutputStream(new FileOutputStream("QuestionBank.dat", t));
		byte[] c = s.getBytes();
		byte[] p = s1.getBytes();
		byte[] q = s2.getBytes();
		byte[] o = s3.getBytes();
		byte[] z = s4.getBytes();
		b.write(c);
		b.write(p);
		b.write(q);
		b.write(o);
		b.write(z);
		b.close();

	}

	void setColor() {
		A1.setStyle("-fx-text-fill: green;");
	}

	void setanswer(ComboBox<String> sd, RadioButton _A1, RadioButton _B1, RadioButton _C1, RadioButton _D1) {
		try {
			c_q = sd.getSelectionModel().getSelectedItem();
			Object[] c = Q.toArray();
			int count = 0;
			for (int i = 0; i < c.length; i++) {
				String R = c[i] + "";

				if (R.equals(c_q)) {
					break;
				} else {
					count++;
				}

			}
			int i = count + 1;
			if ((i) % 5 != 0) {
				_A1.setText(c[i] + "");

				_B1.setText(c[i + 1] + "");
				_C1.setText(c[i + 2] + "");
				_D1.setText(c[i + 3] + "");

			}

		} catch (Exception e1) {

		}

	}

	void editmeth(TextField tx, TextField tx1, TextField tx2, TextField tx3, TextField tx4, ComboBox<String> sd)
			throws Exception {
		v_i = sd.getSelectionModel().getSelectedItem();

		Object[] c = Q.toArray();
		try {

			int count = 0;
			for (int i = 0; i < c.length; i++) {
				String R = c[i] + "";

				if (R.equals(c_q)) {
					break;
				} else {
					count++;
				}

			}
			int i = count + 1;
			if ((i) % 5 != 0) {
				tx.setText(c[i - 1] + "");

				tx1.setText(c[i] + "");
				tx2.setText(c[i + 1] + "");
				tx3.setText(c[i + 2] + "");
				tx4.setText(c[i + 3] + "");

			}

		} catch (Exception e1) {

		}
	}

	void deletemeth() {
		c_q = es.getSelectionModel().getSelectedItem();
		Object[] po = Q.toArray();
		int count = 0;
		for (int i = 0; i < po.length; i++) {
			Object R = po[i];
			if (R.equals(c_q))
				break;
			else
				count++;
		}
		int we = count;
		Q.remove(we);
		Q.remove(we);
		Q.remove(we);
		Q.remove(we);
		Q.remove(we);

		System.out.println(Q);
		File file = new File("QuestionBank.dat");
		if (file.exists())
			file.delete();
		else
			try {
				file.createNewFile();
			} catch (IOException e2) {

				e2.printStackTrace();

			}
		Object[] c = Q.toArray();
		try {
			BufferedOutputStream b = new BufferedOutputStream(new FileOutputStream("QuestionBank.dat", false));

			for (int i = 0; i < c.length; i++) {
				String pnm = " " + c[i] + "\n";
				byte[] oi = pnm.getBytes();
				b.write(oi);
			}
			b.close();
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		viewmeth(es);
	};

}
