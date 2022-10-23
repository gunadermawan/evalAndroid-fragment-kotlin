package com.gunder.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class CategoryFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnDetailCategory: Button = view.findViewById(R.id.btn_detail_category)
        btnDetailCategory.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btn_detail_category) {
            val mDetailCategoryFragment = DetailCategoryFragment()
            val bundle = Bundle()
            bundle.getString(DetailCategoryFragment.EXTRA_NAME, "lifestyle")
            val description = "berisi kategori lifestyle"
            mDetailCategoryFragment.arguments = bundle
            mDetailCategoryFragment.description = description
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction()?.apply {
                replace(R.id.frame_container,
                    mDetailCategoryFragment,
                    DetailCategoryFragment::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

}