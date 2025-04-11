package com.example.chatlib.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chatlib.R

data class ChatMessage(val text: String, val isSender: Boolean)

class ChatAdapter : RecyclerView.Adapter<ChatAdapter.MessageViewHolder>() {

    private val messages = mutableListOf<ChatMessage>()

    fun addMessage(message: ChatMessage) {
        messages.add(message)
        notifyItemInserted(messages.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_message, parent, false)
        return MessageViewHolder(view)
    }

    override fun getItemCount(): Int = messages.size

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messages[position]
        holder.messageText.text = message.text

        val layoutParams = holder.messageText.layoutParams as? ViewGroup.MarginLayoutParams
        if (layoutParams != null) {
            if (message.isSender) {
                layoutParams.marginStart = 100
                layoutParams.marginEnd = 0
                holder.messageText.setBackgroundResource(R.drawable.bg_message_sender)
                holder.messageText.setTextColor(Color.WHITE)
            } else {
                layoutParams.marginStart = 0
                layoutParams.marginEnd = 100
                holder.messageText.setBackgroundResource(R.drawable.bg_message_receiver)
                holder.messageText.setTextColor(Color.BLACK)
            }
            holder.messageText.layoutParams = layoutParams
        } else {
            // Защитимся от потенциального краша, если layoutParams неожиданно null
            holder.messageText.setBackgroundColor(Color.RED)
            holder.messageText.text = "[Ошибка отображения сообщения]"
        }
    }

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val messageText: TextView = itemView.findViewById(R.id.messageText)
    }
}