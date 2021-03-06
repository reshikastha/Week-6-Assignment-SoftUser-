package com.reshika.softusersoftwarica.Fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.reshika.softusersoftwarica.Dashboard.DashboardActivity
import com.reshika.softusersoftwarica.Model.Student
import com.reshika.softusersoftwarica.R


class Student_Fragment : Fragment() {

    private lateinit var etFullname: EditText;
    private lateinit var etAddress: EditText;
    private lateinit var etAge: EditText;
    private lateinit var rdoGender: RadioGroup;
    private lateinit var rdoMale: RadioButton;
    private lateinit var rdoFemale: RadioButton;
    private lateinit var rdoOther: RadioButton;
    private lateinit var imageLink:EditText

    private lateinit var btnSave: Button;



    var gender: String ="";
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_student_, container, false)
        BindView(view)

        btnSave.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                if (TextUtils.isEmpty(etFullname.text.toString())) {
                    etFullname.setError("Enter Fullname");
                    etFullname.requestFocus();
                } else if (TextUtils.isEmpty(etAge.text.toString())) {
                    etAge.setError("Enter Age");
                    etAge.requestFocus();
                } else if (TextUtils.isEmpty(etAddress.text.toString())) {
                    etAddress.setError("Enter Address");
                    etAddress.requestFocus();
                } else if (!rdoMale.isChecked && !rdoFemale.isChecked && !rdoOther.isChecked) {
                    Toast.makeText(context, "Please Select Gender", Toast.LENGTH_SHORT).show();
                } else {
                    val imageLink = imageLink.text.toString()
                    val fullname = etFullname.text.toString();
                    val address = etAddress.text.toString();
                    val age = etAge.text.toString();
                    if(rdoMale.isChecked){
                        gender="Male"
                    }
                    else if (rdoFemale.isChecked){
                        gender="Female"
                    }
                    else if (rdoOther.isChecked){
                        gender="Others"
                    }
                    else{
                        Toast.makeText(
                            context,
                            "Please Select A gender",
                            Toast.LENGTH_SHORT
                        ).show();

                    }

                    DashboardActivity.lisfOfStudent.add(Student(fullname,age,address,gender,imageLink))
                    Toast.makeText(
                        context,
                        "Student Added Successfully",
                        Toast.LENGTH_SHORT
                    ).show();
                    resetFields();
                }
            }
        })


        return view;
    }
     fun BindView(view: View){
        etFullname = view.findViewById(R.id.etFullname);
        etAddress = view.findViewById(R.id.etAddress);
        etAge = view.findViewById(R.id.etAge);
        rdoGender = view.findViewById(R.id.rdoGroup);
        rdoMale = view.findViewById(R.id.rdoMale);
        rdoFemale = view.findViewById(R.id.rdoFemale);
        rdoOther = view.findViewById(R.id.rdoOther);
        imageLink = view.findViewById(R.id.imageLink)
        btnSave = view.findViewById(R.id.btnSave);


    }

    fun resetFields() {

        etFullname.setText("");
        etAge.setText("");
        etAddress.setText("");
        rdoMale.isChecked = false;
        rdoFemale.isChecked = false;
        rdoOther.isChecked = false;
        imageLink.setText("")

    }


}