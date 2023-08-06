package pe.idat.frontend.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import pe.idat.frontend.api.ApiClient
import pe.idat.frontend.api.AuthService
import pe.idat.frontend.api.models.Membership
import pe.idat.frontend.api.models.SignUpRequest
import pe.idat.frontend.api.models.SignUpResponse
import pe.idat.frontend.databinding.FragmentRegisterBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private val authService = ApiClient.authService
    private val membershipService = ApiClient.membershipService

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonRegister.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()
            val name = binding.editTextName.text.toString()
            val lastName = binding.editTextLastName.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && name.isNotEmpty() && lastName.isNotEmpty()) {
                signUp(email, password, name, lastName)
            } else {
                showErrorToast("Por favor complete todos los campos")
            }
        }
    }

    private fun signUp(email: String, password: String, name: String, lastName: String) {
        val signUpRequest = SignUpRequest(email, password, name, lastName)

        authService.signUp(signUpRequest).enqueue(object : Callback<SignUpResponse> {
            override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
                if (response.isSuccessful) {
                    val signUpResponse = response.body()
                    if (signUpResponse != null) {
                        showSuccessToast("Registro exitoso")
                    } else {
                        showErrorToast("Respuesta inválida del servidor")
                    }
                } else {
                    showErrorToast("Respuesta de error del servidor")
                }
            }

            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                showErrorToast("Error en la conexión o respuesta del servidor")
            }
        })
    }



    private fun showSuccessToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun showErrorToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}




