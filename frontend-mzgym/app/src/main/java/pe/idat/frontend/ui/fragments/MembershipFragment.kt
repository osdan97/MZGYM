package pe.idat.frontend.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pe.idat.frontend.api.ApiClient
import pe.idat.frontend.api.models.Membership
import pe.idat.frontend.databinding.FragmentMembershipBinding
import pe.idat.frontend.ui.adapters.MembershipAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MembershipFragment : Fragment() {
    private lateinit var binding: FragmentMembershipBinding
    private val membershipService = ApiClient.membershipService

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMembershipBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = binding.recyclerViewMemberships
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Obtener la lista de membresías y configurar el adaptador
        membershipService.getMemberships().enqueue(object : Callback<List<Membership>> {
            override fun onResponse(call: Call<List<Membership>>, response: Response<List<Membership>>) {
                if (response.isSuccessful) {
                    val memberships = response.body()
                    if (memberships != null) {
                        val adapter = MembershipAdapter(memberships)
                        recyclerView.adapter = adapter
                    }
                }
            }

            override fun onFailure(call: Call<List<Membership>>, t: Throwable) {
                // Manejar el error de conexión o respuesta del servidor
            }
        })
    }
}