package personalfinancemanager;

/**
 *
 * @author Geek Squad
 */

public class Calculator extends javax.swing.JFrame {
    javax.swing.JButton createProfileButton1;
    
    private boolean zerodisp;
    private boolean decdisp;
    private boolean dgrrad;
    private boolean sh;
    
    private byte op;
    
    private double ina;
    private double inb;
    private double out;

    public Calculator() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        display1 = new javax.swing.JTextField();
        display2 = new javax.swing.JTextField();
        memoryread = new javax.swing.JButton();
        memoryclear = new javax.swing.JButton();
        memorysave = new javax.swing.JButton();
        memorydisplay = new javax.swing.JTextField();
        degrees = new javax.swing.JRadioButton();
        radians = new javax.swing.JRadioButton();
        percent = new javax.swing.JButton();
        onedividedbyx = new javax.swing.JButton();
        sin = new javax.swing.JButton();
        cos = new javax.swing.JButton();
        tan = new javax.swing.JButton();
        shift = new javax.swing.JToggleButton();
        pi = new javax.swing.JButton();
        seven = new javax.swing.JButton();
        eight = new javax.swing.JButton();
        nine = new javax.swing.JButton();
        squared = new javax.swing.JButton();
        add = new javax.swing.JButton();
        four = new javax.swing.JButton();
        five = new javax.swing.JButton();
        six = new javax.swing.JButton();
        squareroot = new javax.swing.JButton();
        subtract = new javax.swing.JButton();
        one = new javax.swing.JButton();
        two = new javax.swing.JButton();
        three = new javax.swing.JButton();
        cubed = new javax.swing.JButton();
        multiply = new javax.swing.JButton();
        zero = new javax.swing.JButton();
        decpoint = new javax.swing.JButton();
        negate = new javax.swing.JButton();
        cuberoot = new javax.swing.JButton();
        divide = new javax.swing.JButton();
        equals = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        reset = new javax.swing.JButton();

        setTitle("Calculator");
        setResizable(false);

        display1.setBackground(new java.awt.Color(204, 204, 204));
        display1.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        display1.setText("0");
        display1.setAutoscrolls(false);
        display1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        display1.setFocusable(false);

        display2.setBackground(new java.awt.Color(204, 204, 204));
        display2.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        display2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        display2.setFocusable(false);
        display2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                display2ActionPerformed(evt);
            }
        });

        memoryread.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        memoryread.setText("MR");
        memoryread.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        memoryread.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        memoryread.setFocusable(false);
        memoryread.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memoryreadActionPerformed(evt);
            }
        });

        memoryclear.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        memoryclear.setText("MC");
        memoryclear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        memoryclear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        memoryclear.setFocusable(false);
        memoryclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memoryclearActionPerformed(evt);
            }
        });

        memorysave.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        memorysave.setText("MS");
        memorysave.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        memorysave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        memorysave.setFocusable(false);
        memorysave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memorysaveActionPerformed(evt);
            }
        });

        memorydisplay.setBackground(new java.awt.Color(204, 204, 204));
        memorydisplay.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        memorydisplay.setText("0");
        memorydisplay.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        memorydisplay.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        memorydisplay.setFocusable(false);

        buttonGroup1.add(degrees);
        degrees.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        degrees.setSelected(true);
        degrees.setText("Degrees");
        degrees.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        degrees.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        degrees.setFocusable(false);
        degrees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                degreesActionPerformed(evt);
            }
        });

        buttonGroup1.add(radians);
        radians.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        radians.setText("Radians");
        radians.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        radians.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radians.setFocusable(false);
        radians.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiansActionPerformed(evt);
            }
        });

        percent.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        percent.setText("%");
        percent.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        percent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        percent.setFocusable(false);
        percent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                percentActionPerformed(evt);
            }
        });

        onedividedbyx.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        onedividedbyx.setText("1/x");
        onedividedbyx.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        onedividedbyx.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        onedividedbyx.setFocusable(false);
        onedividedbyx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onedividedbyxActionPerformed(evt);
            }
        });

        sin.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        sin.setText("Sin");
        sin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sin.setFocusable(false);
        sin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinActionPerformed(evt);
            }
        });

        cos.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        cos.setText("Cos");
        cos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cos.setFocusable(false);
        cos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cosActionPerformed(evt);
            }
        });

        tan.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        tan.setText("Tan");
        tan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tan.setFocusable(false);
        tan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanActionPerformed(evt);
            }
        });

        shift.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        shift.setText("Sh");
        shift.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        shift.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        shift.setFocusable(false);
        shift.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shiftMouseClicked(evt);
            }
        });

        pi.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        pi.setText("∏");
        pi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pi.setFocusable(false);
        pi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                piActionPerformed(evt);
            }
        });

        seven.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        seven.setText("7");
        seven.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        seven.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        seven.setFocusable(false);
        seven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sevenActionPerformed(evt);
            }
        });

        eight.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        eight.setText("8");
        eight.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        eight.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eight.setFocusable(false);
        eight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightActionPerformed(evt);
            }
        });

        nine.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        nine.setText("9");
        nine.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nine.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nine.setFocusable(false);
        nine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nineActionPerformed(evt);
            }
        });

        squared.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        squared.setText("x²");
        squared.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        squared.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        squared.setFocusable(false);
        squared.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                squaredActionPerformed(evt);
            }
        });

        add.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        add.setText("+");
        add.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add.setFocusable(false);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        four.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        four.setText("4");
        four.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        four.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        four.setFocusable(false);
        four.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fourActionPerformed(evt);
            }
        });

        five.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        five.setText("5");
        five.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        five.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        five.setFocusable(false);
        five.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveActionPerformed(evt);
            }
        });

        six.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        six.setText("6");
        six.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        six.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        six.setFocusable(false);
        six.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sixActionPerformed(evt);
            }
        });

        squareroot.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        squareroot.setText("√x");
        squareroot.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        squareroot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        squareroot.setFocusable(false);
        squareroot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                squarerootActionPerformed(evt);
            }
        });

        subtract.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        subtract.setText("-");
        subtract.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        subtract.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        subtract.setFocusable(false);
        subtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subtractActionPerformed(evt);
            }
        });

        one.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        one.setText("1");
        one.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        one.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        one.setFocusable(false);
        one.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oneActionPerformed(evt);
            }
        });

        two.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        two.setText("2");
        two.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        two.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        two.setFocusable(false);
        two.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twoActionPerformed(evt);
            }
        });

        three.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        three.setText("3");
        three.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        three.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        three.setFocusable(false);
        three.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                threeActionPerformed(evt);
            }
        });

        cubed.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        cubed.setText("x³");
        cubed.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cubed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cubed.setFocusable(false);
        cubed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cubedActionPerformed(evt);
            }
        });

        multiply.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        multiply.setText("*");
        multiply.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        multiply.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        multiply.setFocusable(false);
        multiply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiplyActionPerformed(evt);
            }
        });

        zero.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        zero.setText("0");
        zero.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        zero.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        zero.setFocusable(false);
        zero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zeroActionPerformed(evt);
            }
        });

        decpoint.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        decpoint.setText(".");
        decpoint.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        decpoint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        decpoint.setFocusable(false);
        decpoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decpointActionPerformed(evt);
            }
        });

        negate.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        negate.setText("±");
        negate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        negate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        negate.setFocusable(false);
        negate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negateActionPerformed(evt);
            }
        });

        cuberoot.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        cuberoot.setText("³√x");
        cuberoot.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cuberoot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cuberoot.setFocusable(false);
        cuberoot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuberootActionPerformed(evt);
            }
        });

        divide.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        divide.setText("/");
        divide.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        divide.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        divide.setFocusable(false);
        divide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                divideActionPerformed(evt);
            }
        });

        equals.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        equals.setText("=");
        equals.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        equals.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        equals.setFocusable(false);
        equals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equalsActionPerformed(evt);
            }
        });

        clear.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        clear.setText("CE");
        clear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear.setFocusable(false);
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        reset.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        reset.setText("C");
        reset.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reset.setFocusable(false);
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(equals, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(divide, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(display2)
                    .addComponent(display1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(memoryread, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(memoryclear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(memorysave, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(degrees)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radians)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(percent, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(onedividedbyx, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(memorydisplay)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(six, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(squareroot, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subtract, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(zero, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(decpoint, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cubed, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(multiply, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(negate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cuberoot, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(seven, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(eight, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nine, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(shift, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(squared, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(display2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(display1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(memorydisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(memoryclear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(memorysave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(memoryread, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(onedividedbyx, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(percent, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(degrees)
                            .addComponent(radians))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(sin, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(tan, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(pi, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(shift, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seven, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eight, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nine, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(squared, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subtract, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(squareroot, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(six, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(multiply, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cubed, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(divide, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cuberoot, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(negate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(decpoint, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zero, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(equals, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void zeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zeroActionPerformed
        if(!zerodisp && !decdisp){ //If what is between the quotation marks is 0,
    //text is set to empty; input b/w quotation marks is written on display screen
            display1.setText(null);
        }
        display1.setText(display1.getText() + "0");
        //0 is writeable only after decimal point or diferent #. Text b/w quotations are then added.
    }//GEN-LAST:event_zeroActionPerformed

    private void oneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oneActionPerformed
        //number entered b/w quotation marks is added and displayed 
        if(!zerodisp && !decdisp){
            display1.setText(null);
        }
      
        display1.setText(display1.getText() + "1");
        zerodisp = true;
    }//GEN-LAST:event_oneActionPerformed

    private void twoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twoActionPerformed
        //number entered b/w quotation marks is added and displayed 
        if(!zerodisp && !decdisp){
            display1.setText(null);
        }
        display1.setText(display1.getText() + "2");
        zerodisp = true;
    }//GEN-LAST:event_twoActionPerformed

    private void threeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_threeActionPerformed
        //number entered b/w quotation marks is added and displayed 
        if(!zerodisp && !decdisp){
            display1.setText(null);
        }
        display1.setText(display1.getText() + "3");
        zerodisp = true;
    }//GEN-LAST:event_threeActionPerformed

    private void fourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fourActionPerformed
        //number entered b/w quotation marks is added and displayed 
        if(!zerodisp && !decdisp){
            display1.setText(null);
        }
        display1.setText(display1.getText() + "4");
        zerodisp = true;
    }//GEN-LAST:event_fourActionPerformed

    private void fiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveActionPerformed
       //number entered b/w quotation marks is added and displayed 
        if(!zerodisp && !decdisp){
            display1.setText(null);
        }
        display1.setText(display1.getText() + "5");
        zerodisp = true;
    }//GEN-LAST:event_fiveActionPerformed

    private void sixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sixActionPerformed
        //number entered b/w quotation marks is added and displayed 
        if(!zerodisp && !decdisp){
            display1.setText(null);
        }
        display1.setText(display1.getText() + "6");
        zerodisp = true;
    }//GEN-LAST:event_sixActionPerformed

    private void sevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sevenActionPerformed
        //number entered b/w quotation marks is added and displayed 
        if(!zerodisp && !decdisp){
            display1.setText(null);
        }
        display1.setText(display1.getText() + "7");
        zerodisp = true;
    }//GEN-LAST:event_sevenActionPerformed

    private void eightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightActionPerformed
        //number entered b/w quotation marks is added and displayed 
        if(!zerodisp && !decdisp){
            display1.setText(null);
        }
        display1.setText(display1.getText() + "8");
        zerodisp = true;
    }//GEN-LAST:event_eightActionPerformed

    private void nineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nineActionPerformed
        //number entered b/w quotation marks is added and displayed 
        if(!zerodisp && !decdisp){
            display1.setText(null);
        }
        display1.setText(display1.getText() + "9");
        zerodisp = true;
    }//GEN-LAST:event_nineActionPerformed

    private void decpointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decpointActionPerformed
        //decimal point is writeable if it isn't on the display
        if(!decdisp){
            display1.setText(display1.getText() + ".");
         //after decimal point is selected decdisp changes to true
         //preventing it from beng displayed more than once
            decdisp = true;
        }
    }//GEN-LAST:event_decpointActionPerformed

    private void negateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_negateActionPerformed
        //this takes the value of the numer entered and copies it into inb
        inb = Double.parseDouble(String.valueOf(display1.getText()));
        //multiplying by -1 inserts or removes the minus from the number 
        out = inb * -1;
        
        //Error message displays when number is out of Double and not w/in decoder range
        if(out > -100000000 && out < 100000000){
            display1.setText(String.valueOf(out));// displays value of out variable
        }
        else{
            display1.setText("Error");
        }
        decdisp = true;
        //used out variable set back to 0
        out = 0;
    }//GEN-LAST:event_negateActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        //reset buttons and clear display text
        display1.setText("0");
        zerodisp = false;
        decdisp = false;
    }//GEN-LAST:event_clearActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
         //reset buttons and clear display text
        display1.setText("0");
        display2.setText(null);
        zerodisp = false;
        decdisp = false;
        ina = 0;
        inb = 0;
        out = 0;
    }//GEN-LAST:event_resetActionPerformed

    private void memoryclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memoryclearActionPerformed
        //reset memory
        memorydisplay.setText("0");
    }//GEN-LAST:event_memoryclearActionPerformed

    private void memorysaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memorysaveActionPerformed
       //numbers entered are saved
        memorydisplay.setText(String.valueOf(display1.getText()));
    }//GEN-LAST:event_memorysaveActionPerformed

    private void onedividedbyxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onedividedbyxActionPerformed
        //get value from display 1 to inb
        inb = Double.parseDouble(String.valueOf(display1.getText()));
        out = 1 / inb; //save 1/inb to out
        
       //display result on display 1
        if(out > -100000000 && out < 100000000){
            display1.setText(String.valueOf(out));
        }
        else{
            display1.setText("Error"); //print error message if input is not w/in range
        }
        //what was performed is displayed on display 2
        display2.setText("1/" + String.valueOf(inb));
        //Double out and op is cleared and set to 0
        out = 0;
        op = 0;
    }//GEN-LAST:event_onedividedbyxActionPerformed

    private void piActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_piActionPerformed
        //PI operation is set
        display1.setText(String.valueOf(Math.PI));
    }//GEN-LAST:event_piActionPerformed

    private void squaredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_squaredActionPerformed
        //get value from display 1 to inb
        inb = Double.parseDouble(String.valueOf(display1.getText()));
        out = inb * inb; // multiply value by itself and store into out
        //display result on display 1
        if(out > -100000000 && out < 100000000){
            display1.setText(String.valueOf(out));
        }
        else{
            display1.setText("Error");//print error message if input is not w/in range
        }
        //what was performed is displayed on display 2
        display2.setText(String.valueOf(inb) + "²");
       //Double out and op is cleared and set to 0
        out = 0; 
        op = 0;
    }//GEN-LAST:event_squaredActionPerformed

    private void squarerootActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_squarerootActionPerformed
        //get value from display 1 to inb
        inb = Double.parseDouble(String.valueOf(display1.getText()));
        out = Math.sqrt(inb);//take the square root of inputted number
        //display result on display 1
        display1.setText(String.valueOf(out));
        
        //what was performed is displayed on display 2
        display2.setText("√" + String.valueOf(inb));
        //Double out and op is cleared and set to 0
        out = 0;
        op = 0;
    }//GEN-LAST:event_squarerootActionPerformed

    private void cubedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cubedActionPerformed
        //get value from display 1 to inb
        inb = Double.parseDouble(String.valueOf(display1.getText()));
        out = inb * inb * inb;//multiply value of inb three times in order to cube number
        //display result on display 1
        if(out > -100000000 && out < 100000000){
            display1.setText(String.valueOf(out));
        }
        else{
            display1.setText("Error");//print error message if input is not w/in range
        }
         //what was performed us displayed on display 2
        display2.setText(String.valueOf(inb) + "³");
        //Double out and op is cleared and set to 0
        out = 0;
        op = 0;
    }//GEN-LAST:event_cubedActionPerformed

    private void cuberootActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuberootActionPerformed
        //get value from display 1 to inb
        inb = Double.parseDouble(String.valueOf(display1.getText()));
        out = Math.cbrt(inb);//take the cubed root of inputted value
        //display result on display 1   
        display1.setText(String.valueOf(out));
        //what was performed us displayed on display 2
        display2.setText("³√" + String.valueOf(inb));
       //Double out and op is cleared and set to 0
        out = 0;
        op = 0;
    }//GEN-LAST:event_cuberootActionPerformed

    private void shiftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shiftMouseClicked
        //toggle button is created
        if (!sh){
            sh = true;
        }
        else{
            sh = false;
        }
    }//GEN-LAST:event_shiftMouseClicked

    private void sinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinActionPerformed
        //get value from display 1 to inb
        inb = Double.parseDouble(String.valueOf(display1.getText()));
        
        if(!sh){
            //if degrees is selected, input is converted from degrees to radians
            if(!dgrrad){
                //display input on display 2
                display2.setText("sin(" + String.valueOf(inb) + ")");
                inb = inb * 0.0174532925;
            }
          //sin operation is created 
            out = Math.sin(inb);
        }
        else{
            display2.setText("sinh(" + String.valueOf(inb) + ")");
            out = Math.sinh(inb);
        }
        //result is outputted w/o prevention
        display1.setText(String.valueOf(out));
        //Double out and op is cleared and set to 0
        out = 0;
        op = 0;
    }//GEN-LAST:event_sinActionPerformed

    private void cosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cosActionPerformed
        //get value from display 1 to inb
        inb = Double.parseDouble(String.valueOf(display1.getText()));
        if(!sh){
           //if degrees is selected, input is converted from degrees to radians
            if(!dgrrad){
                //display input on display 2
                display2.setText("cos(" + String.valueOf(inb) + ")");
                inb = inb * 0.0174532925;
            }
            //sin operation is created 
            out = Math.cos(inb);
        }
        else{
            display2.setText("cosh(" + String.valueOf(inb) + ")");
            out = Math.cosh(inb);
        }
        //result is outputted w/o prevention
        display1.setText(String.valueOf(out));
        //Double out and op is cleared and set to 0
        out = 0;
        op = 0;
    }//GEN-LAST:event_cosActionPerformed

    private void tanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanActionPerformed
        //get value from display 1 to inb
        inb = Double.parseDouble(String.valueOf(display1.getText()));
        if(!sh){
          //if degrees is selected, input is converted from degrees to radians
            if(!dgrrad){
                display2.setText("tan(" + String.valueOf(inb) + ")");
                inb = inb * 0.0174532925;
            }
           //sin operation is created 
            out = Math.tan(inb);
        }
        else{
            display2.setText("tanh(" + String.valueOf(inb) + ")");
            out = Math.tanh(inb);
        }
       //result is outputted w/o prevention 
        display1.setText(String.valueOf(out));
        //Double out and op is cleared and set to 0
        out = 0;
        op = 0;
    }//GEN-LAST:event_tanActionPerformed

    private void degreesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_degreesActionPerformed
        //radio button for when degree is selected, radians is set to false
        dgrrad = false;
    }//GEN-LAST:event_degreesActionPerformed

    private void radiansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiansActionPerformed
       //radio button for when radians is selected, degrees is set to false
        dgrrad = true;
    }//GEN-LAST:event_radiansActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        //if op == 0; op case:nothing
        if(op == 0){
            //save into ina
            ina = Double.parseDouble(String.valueOf(display1.getText()));
        }
        else{
            //save into inb
            inb = Double.parseDouble(String.valueOf(display1.getText()));
        }
        //if op == 1; op case:add
        if(op == 1){
            //add values inputted and store into ina
            ina = ina + inb;
        }
       //if op == 2; op case:subtract
        if(op == 2){
           //subtract values inputted and store into ina
            ina = ina - inb;
        }
       //if op == 3; op case:multiply
        if(op == 3){
           //multiply values inputted and store into ina
            ina = ina * inb;
        }
       //if op == 4; op case:divide
        if(op == 4){
           //divide values inputted and store into ina
            ina = ina / inb;
        }
        
       //if op == 5; op case:percent
        if(op == 5){
           //multiply values inputted and divide by 100 and store into ina
            ina = ina * inb / 100;
        }
        //Display 1 is cleared after pressig any operation
        display1.setText("0");
        display2.setText(String.valueOf(ina) + " + ");
        
        op = 1;
        
        //set to false
        decdisp = false;
        zerodisp = false;
    }//GEN-LAST:event_addActionPerformed

    private void subtractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subtractActionPerformed
        //if op == 0; op case:nothing
        if(op == 0){
            //save into ina
            ina = Double.parseDouble(String.valueOf(display1.getText()));
        }
        //save into inb
        else{
            inb = Double.parseDouble(String.valueOf(display1.getText()));
        }
        //if op == 1; op case:add 
        if(op == 1){
            //add values inputted and store into ina
            ina = ina + inb;
        }
        //if op == 2; op case:subtract
        if(op == 2){
            //subtract values inputted and store into ina
            ina = ina - inb;
        }
       //if op == 3; op case:multiply 
        if(op == 3){
           //multiply values inputted and store into ina 
            ina = ina * inb;
        }
        //if op == 4; op case:divide   
        if(op == 4){
            //divide values inputted and store into ina
            ina = ina / inb;
        }
        //if op == 5; op case:percent 
        if(op == 5){
           //multiply values inputted and divide by 100 and store into ina
            ina = ina * inb / 100;
        }
       //Display 1 is cleared after pressig any operation 
        display1.setText("0");
        display2.setText(String.valueOf(ina) + " - ");
        
        op = 2;
        
         //set to false
        decdisp = false;
        zerodisp = false;
    }//GEN-LAST:event_subtractActionPerformed

    private void multiplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiplyActionPerformed
        //if op == 0; op case:nothing
        if(op == 0){
          //save into ina
            ina = Double.parseDouble(String.valueOf(display1.getText()));
        }
        else{
            //save into inb
            inb = Double.parseDouble(String.valueOf(display1.getText()));
        }
        //if op == 1; op case:add  
        if(op == 1){
           //add values inputted and store into ina
            ina = ina + inb;
        }
        //if op == 2; op case:subtract 
        if(op == 2){
            //subtract values inputted and store into ina
            ina = ina - inb;
        }
       //if op == 3; op case:multiply  
        if(op == 3){
          //multiply values inputted and store into ina
            ina = ina * inb;
        }
        //if op == 4; op case:divide   
        if(op == 4){
         //divide values inputted and store into ina
            ina = ina / inb;
        }
        //if op == 5; op case:percent 
        if(op == 5){
         //multiply values inputted and divide by 100 and store into ina
            ina = ina * inb / 100;
        }
        //Display 1 is cleared after pressig any operation 
        display1.setText("0");
        display2.setText(String.valueOf(ina) + " * ");
        
        op = 3;
         //set to false
        decdisp = false;
        zerodisp = false;
    }//GEN-LAST:event_multiplyActionPerformed

    private void divideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_divideActionPerformed
        
        //if op == 0; op case:nothing
        if(op == 0){
        //save into ina
            ina = Double.parseDouble(String.valueOf(display1.getText()));
        }
        else{
          //save into inb
            inb = Double.parseDouble(String.valueOf(display1.getText()));
        }
        //if op == 1; op case:add  
        if(op == 1){
           //add values inputted and store into ina
            ina = ina + inb;
        }
        //if op == 2; op case: subtract  
        if(op == 2){
            //subtract values inputted and store into ina
            ina = ina - inb;
        }
        //if op == 3; op case:multiply  
        if(op == 3){
            //multiply values inputted and store into ina
            ina = ina * inb;
        }
       //if op == 4; op case:divide  
        if(op == 4){
            //divide values inputted and store into ina
            ina = ina / inb;
        }
       //if op == 5; op case:percent   
        if(op == 5){
             //multiply values inputted and divide by 100 and store into ina
            ina = ina * inb / 100;
        }
        //Display 1 is cleared after pressig any operation  
        display1.setText("0");
        display2.setText(String.valueOf(ina) + " / ");
        
        op = 4;
          //set to false
        decdisp = false;
        zerodisp = false;
    }//GEN-LAST:event_divideActionPerformed

    private void percentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_percentActionPerformed
        //retrieve input stored into ina
        ina = Double.parseDouble(String.valueOf(display1.getText()));
        //clear display 1 by setting to 0
        display1.setText("0");
        display2.setText(String.valueOf(ina) + "%(");
        //set to false
        decdisp = false;
        zerodisp = false;
        //set op to 5
        op = 5;
    }//GEN-LAST:event_percentActionPerformed

    private void equalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equalsActionPerformed
        //retrieve input stored into ina
        inb = Double.parseDouble(String.valueOf(display1.getText()));
        
        //if op == 0; op case:nothing
        if(op == 0){
         //copy value of inb into display 2
            out = inb;
            display2.setText(String.valueOf(inb));
        }
        //if op == 1; op case:add
        if(op == 1){
          //copy value of inb into display 2
            out = ina + inb;
            display2.setText(display2.getText() + String.valueOf(inb));
        }
        //if op == 2; op case:subtract
        if(op == 2){
         //copy value of inb into display 2
            out = ina - inb;
            display2.setText(display2.getText() + String.valueOf(inb));
        }
        //if op == 3; op case:multiply
        if(op == 3){
         //copy value of inb into display 2    
            out = ina * inb;
            display2.setText(display2.getText() + String.valueOf(inb));
        }
       //if op == 4; op case:divide 
        if(op == 4){
             //copy value of inb into display 2
            out = ina / inb;
            display2.setText(display2.getText() + String.valueOf(inb));
        }
       //if op == 5; op case:percent
        if(op == 5){
       //copy value of inb into display 2
            out = ina * inb / 100;
            display2.setText(display2.getText() + String.valueOf(inb) + ")");
        }
        //display result on display 1
        if(out > -100000000 && out < 100000000){
            display1.setText(String.valueOf(out));
        }
        else{
            display1.setText("Error");//print error message if input is not w/in range
        }
        //set Doubles to 0
        ina = 0;
        inb = 0;
        out = 0;
        
        op = 0;
        //set to false
        decdisp = false;
        zerodisp = false;
    }//GEN-LAST:event_equalsActionPerformed

    private void display2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_display2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_display2ActionPerformed

    private void memoryreadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memoryreadActionPerformed
        //displays serves as memory
        display1.setText(String.valueOf(memorydisplay.getText()));
    }//GEN-LAST:event_memoryreadActionPerformed

 
    public static void main(String args[]) {

      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculator().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton clear;
    private javax.swing.JButton cos;
    private javax.swing.JButton cubed;
    private javax.swing.JButton cuberoot;
    private javax.swing.JButton decpoint;
    private javax.swing.JRadioButton degrees;
    private javax.swing.JTextField display1;
    private javax.swing.JTextField display2;
    private javax.swing.JButton divide;
    private javax.swing.JButton eight;
    private javax.swing.JButton equals;
    private javax.swing.JButton five;
    private javax.swing.JButton four;
    private javax.swing.JButton memoryclear;
    private javax.swing.JTextField memorydisplay;
    private javax.swing.JButton memoryread;
    private javax.swing.JButton memorysave;
    private javax.swing.JButton multiply;
    private javax.swing.JButton negate;
    private javax.swing.JButton nine;
    private javax.swing.JButton one;
    private javax.swing.JButton onedividedbyx;
    private javax.swing.JButton percent;
    private javax.swing.JButton pi;
    private javax.swing.JRadioButton radians;
    private javax.swing.JButton reset;
    private javax.swing.JButton seven;
    private javax.swing.JToggleButton shift;
    private javax.swing.JButton sin;
    private javax.swing.JButton six;
    private javax.swing.JButton squared;
    private javax.swing.JButton squareroot;
    private javax.swing.JButton subtract;
    private javax.swing.JButton tan;
    private javax.swing.JButton three;
    private javax.swing.JButton two;
    private javax.swing.JButton zero;
    // End of variables declaration//GEN-END:variables
}
