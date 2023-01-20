package com.example.clgmate_app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class AboutFragment extends Fragment {

    TextView aboutText,aboutDetails,aboutDetails2,aboutDetails3;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        aboutText = view.findViewById(R.id.tvAboutText);
        aboutDetails = view.findViewById(R.id.tvFaAboutDetails);
        aboutDetails.setText("Government Engineering College Bilaspur, is a provider of University level technical education and research in Chhattisgarh state. The institute is is affiliated to Chhattisgarh Swami Vivekanand Technical University (CSVTU), Bhilai and approved by All India Council for Technical Education (AICTE), Delhi. Since its inception in 1964, college is a dynamic, fast growing educational institution. College provides a safe and supportive environment to foster the academic development and welfare of students. Imbibed with the message of “Yogah Karmasu Kaushalam”, the institute is offering a flexible and real world based approach in education.\n\n\n" +
                "GEC Bilaspur offers 7 courses for Graduation i.e., Civil Engineering, Mechanical Engineering, Electrical Engineering, Mining Engineering, Electronics and Telecommunications, Computer Science and Engineering, and Information Technology and 1 PG Course in Thermal Engineering. The institute is approved Research Centre of Chhattisgarh Swami Vivekanand Technical University (CSVTU), Bhilai.\n\n\n"
        +"The city of Bilaspur is a main junction on Howrah-Mumbai rail route of South Eastern Central railway. The distance of the institution from railway station is 10 km. The nearest airport is Bilasa Devi Kewat Airport, Bilaspur  which is 20km away from the institute on Bilaspur-Raipur National Highway. This institute is located on Korba road amidst the peaceful, lush green and natural region of Koni village. It is well connected by Rail ,Roadways and through air to other main cities."
        );
        aboutDetails2 = view.findViewById(R.id.tvFaAboutDetails2);

        aboutDetails2.setText("To be a global leader by imparting quality technical education and innovative research for the betterment of the industry and society.");

        aboutDetails3 = view.findViewById(R.id.tvFaAboutDetails3);
        aboutDetails3.setText("Developing technical competencies to enhance employability and entrepreneurship.Promoting research and consultancy activities to meet the need of industries. Inculcating ethical values and leadership qualities for sustainable development.");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_about, container, false);
    }
}