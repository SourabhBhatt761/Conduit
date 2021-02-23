package com.SRB.conduit.ui.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.SRB.conduit.R
import com.SRB.conduit.databinding.ListItemArticleBinding
import com.SRB.conduit.extensions.loadImage
import com.SRB.conduit.extensions.timeStamp
import com.srb.models.entities.Article

class ArticleFeedAdapter(val onArticleClicked: (slug: String) -> Unit) :
        ListAdapter<Article, ArticleFeedAdapter.ArticleViewHolder>(
                object : DiffUtil.ItemCallback<Article>() {
                    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                        return oldItem == newItem
                    }

                    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                        return oldItem.toString() == newItem.toString()
                    }
                }
        ) {
    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
                parent.context.getSystemService(LayoutInflater::class.java).inflate(
                        R.layout.list_item_article,
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        ListItemArticleBinding.bind(holder.itemView).apply {
            val article = getItem(position)

            authorTextView.text = article.author.username
            titleTextView.text = article.title
            bodySnippetTextView.text = article.body
            dateTextView.timeStamp = article.createdAt
            avatarImageView.loadImage(article.author.image, true)

            root.setOnClickListener { onArticleClicked(article.slug) }

        }

    }


}