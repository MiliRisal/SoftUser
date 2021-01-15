package com.example.week6_softuser.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.week6_softuser.R

class AboutusFragment : Fragment() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_aboutus, container, false)
        webView = view.findViewById(R.id.webView)
        webView.loadUrl("https://softwarica.edu.np/about-softwarica/")

        webView.setWebViewClient(WebViewClient())
        webView.getSettings().setJavaScriptEnabled(true);

        return view
    }
}