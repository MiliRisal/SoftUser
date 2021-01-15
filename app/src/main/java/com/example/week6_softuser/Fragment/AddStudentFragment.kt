package com.example.week6_softuser.Fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.week6_softuser.R
import com.example.week6_softuser.model.CommonData
import com.example.week6_softuser.model.Users

class AddStudentFragment : Fragment(), View.OnClickListener {
    private lateinit var etFn: EditText
    private lateinit var etAge: EditText
    private lateinit var rbGroup: RadioGroup
    private lateinit var rbMale: RadioButton
    private lateinit var rbFemale: RadioButton
    private lateinit var rbOther: RadioButton
    private lateinit var etAdd: EditText
    private lateinit var etImg: EditText
    private lateinit var btnSave: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_add_student, container, false)

        etFn=view.findViewById(R.id.etFn)
        etAge=view.findViewById(R.id.etAge)
        rbGroup = view.findViewById(R.id.rbGroup)
        rbMale=view.findViewById(R.id.rbMale)
        rbFemale=view.findViewById(R.id.rbFemale)
        rbOther=view.findViewById(R.id.rbOther)
        etAdd=view.findViewById(R.id.etAdd)
        etImg=view.findViewById(R.id.etImg)
        btnSave=view.findViewById(R.id.btnSave)

        btnSave.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnSave->{
                Toast.makeText(context,"New student added!", Toast.LENGTH_SHORT).show()
                var img = etImg.text.toString()
                var fn = etFn.text.toString()
                var age = etAge.text.toString().toInt()

                var gender=rbGroup.checkedRadioButtonId.toString()
                if(rbGroup.checkedRadioButtonId!=1){
                    if(rbMale.isChecked){
                        gender="Male"
                    }else if (rbFemale.isChecked){
                        gender="Female"
                    }else if (rbOther.isChecked){
                        gender="other"
                    }
                }
                var address = etAdd.text.toString();
                CommonData.addStudent(Users(img,fn,age,address,gender))

                etFn.setText("")
                etAge.setText("")
                rbMale.isChecked = false
                rbFemale.isChecked=false
                rbOther.isChecked=false
                etAdd.setText("")
                etImg.setText("")

            }
        }
    }
}