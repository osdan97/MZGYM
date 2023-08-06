package pe.idat.frontend.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.idat.frontend.api.models.Membership
import pe.idat.frontend.databinding.ItemMembershipBinding

class MembershipAdapter(private val memberships: List<Membership>) :
    RecyclerView.Adapter<MembershipAdapter.MembershipViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MembershipViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMembershipBinding.inflate(inflater, parent, false)
        return MembershipViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MembershipViewHolder, position: Int) {
        val membership = memberships[position]
        holder.bind(membership)
    }

    override fun getItemCount(): Int = memberships.size

    class MembershipViewHolder(private val binding: ItemMembershipBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(membership: Membership) {
            binding.apply {
                textViewMembershipName.text = membership.name
                textViewMembershipPrice.text = membership.price.toString()
            }
        }
    }
}