package pe.idat.frontend.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import pe.idat.frontend.api.ApiClient
import pe.idat.frontend.api.models.SignInRequest
import pe.idat.frontend.api.models.SignInResponse
import pe.idat.frontend.databinding.FragmentLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val authService = ApiClient.authService

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSignIn.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                signIn(email, password)
            } else {
                showToast("Por favor ingrese correo y contraseña")
            }
        }
    }

    private fun signIn(email: String, password: String) {
        val signInRequest = SignInRequest(email, password)

        authService.signIn(signInRequest).enqueue(object : Callback<SignInResponse> {
            override fun onResponse(call: Call<SignInResponse>, response: Response<SignInResponse>) {
                if (response.isSuccessful) {
                    val signInResponse = response.body()
                    if (signInResponse != null) {
                            val token = signInResponse.token
                            // Guardar el token en SharedPreferences o en alguna otra forma de persistencia.

                    } else {
                        showToast("Respuesta inválida del servidor")
                    }
                } else {
                    showToast("Error en la respuesta del servidor")
                }
            }

            override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                showToast("Error en la conexión o respuesta del servidor")
            }
        })
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}